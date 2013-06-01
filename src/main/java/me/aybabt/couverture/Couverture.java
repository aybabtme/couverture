/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Antoine Grondin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package me.aybabt.couverture;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Automagically improves testing coverage of your package.  Add Couverture to your tests
 * and let the magic happen.
 */
public class Couverture {

  private Set<Class<?>> victims;
  private Reflections   reflections;

  /**
   * Prepares the victims in the given package name.
   *
   * @param packageNameOfVictims is the package in which the classes to be victim of major
   *                             test coverage improvement... are located
   * @throws VictimlessPackageException if the given package is victimless, that is, there
   *                                    are no classes to abuse within that package.
   */
  public Couverture(String packageNameOfVictims) throws VictimlessPackageException {

    if (packageNameOfVictims == null) {
      throw new IllegalArgumentException("packageName can't be null");
    }

    List<ClassLoader> classLoadersList = new LinkedList<>();
    classLoadersList.add(ClasspathHelper.contextClassLoader());
    classLoadersList.add(ClasspathHelper.staticClassLoader());

    this.reflections = initializeReflections(packageNameOfVictims, classLoadersList);
    this.victims = reflections.getSubTypesOf(Object.class);

    if (victims == null || victims.isEmpty()) {
      throw new VictimlessPackageException(packageNameOfVictims);
    }
  }

  /**
   * Automagically bumps the coverage of the package provided in the constructor.
   */
  public void bumpThatCoverage() {

    for (Class<?> aVictim : victims) {
      callAllTheConstructors(aVictim);
    }

  }

  ////////////////////////////////////////////////////////////////////////////////////////
  // Helper
  ////////////////////////////////////////////////////////////////////////////////////////

  private Reflections initializeReflections(final String packageNameOfVictims,
                                            final List<ClassLoader> classLoadersList) {

    SubTypesScanner scanner = new SubTypesScanner(false);
    ClassLoader[] loaders = classLoadersList.toArray(new ClassLoader[0]);
    FilterBuilder filter = new FilterBuilder() {{
      include(FilterBuilder.prefix(packageNameOfVictims));
    }};

    ConfigurationBuilder builder = new ConfigurationBuilder()
        .setScanners(scanner, new ResourcesScanner())
        .setUrls(ClasspathHelper.forClassLoader(loaders))
        .filterInputsBy(filter);

    return new Reflections(builder);
  }

  ////////////////////////////////////////////////////////////////////////////////////////
  // Invokes and instantiates all the things!
  ////////////////////////////////////////////////////////////////////////////////////////

  private <T> void callAllTheConstructors(Class<T> aVictim) {
    Constructor<T>[] constructors = (Constructor<T>[]) aVictim.getDeclaredConstructors();

    for (Constructor<T> aConstructor : constructors) {
      T aVictimInstance = instantiateWithStuff(aConstructor);
      callAllTheMethods(aVictimInstance);
    }

  }

  private <T> void callAllTheMethods(T aVictim) {
    Method[] methods = aVictim.getClass().getDeclaredMethods();

    for (Method aMethod : methods) {
      callMethodWithStuff(aVictim, aMethod);
    }
  }

  private <T> T callMethodWithStuff(Object aVictim, Method aMethod) {
    aMethod.setAccessible(true);
    Class<?>[] types = aMethod.getParameterTypes();
    List<Object> args = instantiateArguments(types);
    try {
      Object returnValue = aMethod.invoke(aVictim, args.toArray());
      return returnValue == null ? null : (T) returnValue;
    } catch (IllegalAccessException | InvocationTargetException e) {
      // Oh noes
      e.printStackTrace();
    }

    return null;
  }

  private <T> T instantiateWithStuff(Constructor aConstructor) {
    Class<?>[] types = aConstructor.getParameterTypes();

    List<Object> args = instantiateArguments(types);

    try {
      aConstructor = aConstructor.getDeclaringClass().getConstructor(types);
    } catch (NoSuchMethodException e) {
      // that's a lie!
    }

    aConstructor.setAccessible(true);

    try {
      return (T) aConstructor.newInstance(args.toArray());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private List<Object> instantiateArguments(Class<?>[] types) {
    List<Object> args = new LinkedList<>();

    for (int i = 0; i < types.length; i++) {
      try {
        args.add(newType(types[i]));
      } catch (Exception e) {
        e.printStackTrace();
        args.add(null);
      }
    }
    return args;
  }

  private <T> T newType(Class<T> type)
      throws InstantiationException, IllegalAccessException,
             VictimDoesNotWantToLiveException {
    if (type == null) {
      return (T) new Object();
    }
    if (type.isPrimitive()) {
      return (T) Primitive.defaultPrimitive(type);
    } else if (type.isArray()) {
      return (T) newArray(type.getComponentType());
    }

    return newObject(type);
  }

  private <T> Object newArray(Class<T> type)
      throws IllegalAccessException, VictimDoesNotWantToLiveException,
             InstantiationException {

    if (type.isPrimitive()) {
      return Primitive.newPrimitiveArray(type);
    }

    Object[] array = (T[]) Array.newInstance(type, 5);

    for (int i = 0; i < array.length; i++) {
      array[i] = newType(type.getComponentType());
    }

    return array;

  }

  private <T> T newObject(Class<T> type) throws VictimDoesNotWantToLiveException {
    Constructor[] constructors = type.getConstructors();
    if (constructors.length != 0) {
      return instantiateWithStuff(constructors[0]);
    }
    // No constructor, maybe there's a factory method
    List<Method> factoryMethods = findFactoryMethodOnType(type);

    for (Method aFactory : factoryMethods) {
      T result = callMethodWithStuff(null, aFactory);
      if (result != null) {
        return result;
      }
    }

    throw new VictimDoesNotWantToLiveException(type);

  }

  private List<Method> findFactoryMethodOnType(Class<?> type) {
    Method[] methods = type.getMethods();
    return findFactoryMethodForType(type, Arrays.asList(methods));
  }

  private List<Method> findFactoryMethodForType(final Class<?> target,
                                                final List<Method> methods) {
    return new ArrayList<Method>() {{
      for (Method aMethod : methods) {
        if (aMethod.getReturnType().equals(target)) {
          add(aMethod);
        }
      }
    }};
  }
}









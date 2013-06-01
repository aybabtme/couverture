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
package with_coverage;

import java.util.Arrays;

import me.aybabt.couverture.Meta;

public class MyPojoWithCoverage {

  public MyPojoWithCoverage(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + "arg=" + arg);
  }

  MyPojoWithCoverage(String arg1, String arg2) {
    System.out.println("Called " + Meta.prettyPrint());
  }

  protected MyPojoWithCoverage(String arg1, String arg2, String arg3) {
    System.out.println("Called " + Meta.prettyPrint() + "arg1=" + arg1
                       + " arg2=" + arg2 + " arg3=" + arg3);
  }

  private MyPojoWithCoverage(String arg1, String arg2, String arg3, String arg4) {
    System.out.println("Called " + Meta.prettyPrint() + "arg1=" + arg1
                       + " arg2=" + arg2 + " arg3=" + arg3 + " arg4=" + arg4);
  }

  private static void someStaticPrivateMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  private static Object someStaticPrivateOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  private static void someStaticPrivateMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  private static void someStaticPrivateMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  private static void someStaticPrivateMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  public static void someStaticPublicMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  public static Object someStaticPublicOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  public static void someStaticPublicMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  public static void someStaticPublicMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  public static void someStaticPublicMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  static void someStaticDefaultMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  static Object someStaticDefaultOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  static void someStaticDefaultMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  static void someStaticDefaultMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  static void someStaticDefaultMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  protected static void someStaticProtectedMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  protected static Object someStaticProtectedOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  protected static void someStaticProtectedMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  protected static void someStaticProtectedMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  protected static void someStaticProtectedMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  private void somePrivateMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  private Object somePrivateOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  private void somePrivateMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  private void somePrivateMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  private void somePrivateMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  public void somePublicMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  public Object somePublicOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  public void somePublicMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  public void somePublicMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  public void somePublicMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  void someDefaultMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  Object someDefaultOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  void someDefaultMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  void someDefaultMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  void someDefaultMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }

  protected void someProtectedMethod() {
    System.out.println("Called " + Meta.prettyPrint());
  }

  protected Object someProtectedOtherMethod() {
    System.out.println("Called " + Meta.prettyPrint());
    return null;
  }

  protected void someProtectedMethodWithArgs(String arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  protected void someProtectedMethodWithArgs(int arg) {
    System.out.println("Called " + Meta.prettyPrint() + " arg=" + arg);
  }

  protected void someProtectedMethodWithArgs(Object[] arg) {
    System.out.println("Called " + Meta.prettyPrint()
                       + " arg=" + Arrays.deepToString(arg));
  }
}

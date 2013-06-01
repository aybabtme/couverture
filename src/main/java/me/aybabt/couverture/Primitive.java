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

/**
 * Project: couverture. Author: antoine. Date: 2013-06-01.
 */
class Primitive {

  public static <T> Object newPrimitiveArray(Class<T> type) {

    if (type.equals(byte.class)) {
      return newRandomByteArray();
    } else if (type.equals(int.class)) {
      return newRandomIntArray();
    } else if (type.equals(double.class)) {
      return newRandomDoubleArray();
    } else if (type.equals(char.class)) {
      return newRandomCharArray();
    } else if (type.equals(boolean.class)) {
      return newRandomBooleanArray();
    } else if (type.equals(long.class)) {
      return newRandomLongArray();
    } else if (type.equals(float.class)) {
      return newRandomFloatArray();
    } else if (type.equals(short.class)) {
      return newRandomShortArray();
    }

    throw new RuntimeException("Not a primitive type: " + type.getCanonicalName());
  }


  public static <T> Object defaultPrimitive(Class<T> type) {
    if (type.equals(byte.class)) {
      return (byte) Math.random();
    } else if (type.equals(int.class)) {
      return (int) Math.random();
    } else if (type.equals(double.class)) {
      return Math.random();
    } else if (type.equals(char.class)) {
      return (char) Math.random();
    } else if (type.equals(boolean.class)) {
      return Math.random() > 0.5 ? true : false;
    } else if (type.equals(long.class)) {
      return (long) Math.random();
    } else if (type.equals(float.class)) {
      return (float) Math.random();
    } else if (type.equals(short.class)) {
      return (short) Math.random();
    }

    throw new RuntimeException("Not a primitive type: " + type.getCanonicalName());
  }

  public static double getRandomInRange(double min, double max){
    double rand = Math.random() * (max - min);
    return rand + min;
  }

  public static Object newRandomShortArray() {
    short[] array = new short[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = (short) getRandomInRange(Short.MIN_VALUE, Short.MAX_VALUE);
    }
    return array;
  }

  public static Object newRandomFloatArray() {
    float[] array = new float[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = (float) getRandomInRange(Float.MIN_VALUE, Float.MAX_VALUE);
    }
    return array;
  }

  public static Object newRandomLongArray() {
    long[] array = new long[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = (long) getRandomInRange(Long.MIN_VALUE, Long.MAX_VALUE);
    }
    return array;
  }

  public static Object newRandomBooleanArray() {
    boolean[] array = new boolean[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = getRandomInRange(0, 1) > 0.5 ? true : false;
    }
    return array;
  }

  public static Object newRandomCharArray() {
    char[] array = new char[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = (char) getRandomInRange(Character.MIN_VALUE, Character.MAX_VALUE);
    }
    return array;
  }

  public static Object newRandomDoubleArray() {
    double[] array = new double[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = getRandomInRange(Double.MIN_VALUE, Double.MAX_VALUE);
    }
    return array;
  }

  public static Object newRandomIntArray() {
    int[] array = new int[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = (int) getRandomInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    return array;
  }

  public static Object newRandomByteArray() {
    byte[] array = new byte[(int) getRandomInRange(0, 25)];
    for(int i = 0; i < array.length; i++){
      array[i] = (byte) getRandomInRange(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }
    return array;
  }

}

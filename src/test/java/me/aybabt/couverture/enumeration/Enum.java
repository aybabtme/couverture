package me.aybabt.couverture.enumeration;

import me.aybabt.couverture.Meta;

public enum Enum {

  EARTH("what"),
  MOON("hoooo"),
  SUN("sun"),
  BALLS("balls");

  private String value;

  public String toString(){
    System.out.println("Hello from inside of :" + Meta.prettyPrint());
    return value;
  }

  Enum(String name){
    this.value = name;
  }

}
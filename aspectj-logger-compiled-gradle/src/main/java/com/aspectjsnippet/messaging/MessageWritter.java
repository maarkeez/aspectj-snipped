package com.aspectjsnippet.messaging;

import com.aspectjsnippet.model.LogAspect;

public class MessageWritter {
  
  @LogAspect
  public void write () {
    System.out.println("PUBLIC:  Hello world ");
    writeProtected();
    writePrivate();
    writePackageVisible();
  }
  
  @LogAspect
  protected void writeProtected () {
    System.out.println("PROTECTED:  Hello world");
  }
  
  @LogAspect
  private void writePrivate () {
    System.out.println("PRIVATE: Hello world");
  }
  
  @LogAspect
  void writePackageVisible () {
    System.out.println("PACKAGE VISIBLE: Hello world");
  }
}
package com.chute.sdk.v2.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;


public class TestUtil {

  public static final String TAG = TestUtil.class.getSimpleName();

  
  public static String readResourceAsString(String path) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    try {
      return IOUtils.toString(loader.getResourceAsStream(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("Unable to read resource, check if " + path + " Exists");
  }
  public static InputStream readResourceAsStream(String path) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    return loader.getResourceAsStream(path);
  }
  
}

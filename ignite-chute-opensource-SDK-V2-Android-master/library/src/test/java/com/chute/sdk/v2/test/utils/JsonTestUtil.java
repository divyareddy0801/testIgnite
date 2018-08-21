package com.chute.sdk.v2.test.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonTestUtil {

  public static boolean compare(String first, String second) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode tree1 = mapper.readTree(first);
      JsonNode tree2 = mapper.readTree(second);
      return tree1.equals(tree2);
    } catch (IOException e) {
    }
    throw new RuntimeException("Unable to compare JSON strings");
  }
}

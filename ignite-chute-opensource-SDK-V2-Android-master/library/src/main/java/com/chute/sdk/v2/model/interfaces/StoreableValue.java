package com.chute.sdk.v2.model.interfaces;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public interface StoreableValue {

  public String storeValueToJson();

}

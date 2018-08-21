package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.AlbumModel;

public class AlbumBlueprint {

  public static AlbumModel create() {
    AlbumModel model = new AlbumModel();
    model.setId("423dsf");
    model.setName("car make");
    return model;
  }
}
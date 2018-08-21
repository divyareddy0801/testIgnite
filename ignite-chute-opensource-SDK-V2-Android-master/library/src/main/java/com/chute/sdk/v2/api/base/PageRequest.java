package com.chute.sdk.v2.api.base;

import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.RequestMethod;
import com.dg.libs.rest.parsers.HttpResponseParser;
import com.dg.libs.rest.requests.RestClientRequest;


public class PageRequest<T> extends RestClientRequest<T> {

  public PageRequest(RequestMethod requestMethod, String url,
      HttpResponseParser<T> parser, HttpCallback<T> callback) {
    setRequestMethod(requestMethod);
    setUrl(url);
    setCallback(callback);
    setParser(parser);
  }

  public static final String TAG = PageRequest.class.getSimpleName();

}

package com.chute.sdk.v2.api.upload;

import com.chute.sdk.v2.exceptions.UploadInterruptedException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.internal.Util;

import java.io.File;
import java.io.IOException;

import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class CountingFileRequestBody extends RequestBody {

  private static final int SEGMENT_SIZE = 2048; // okio.Segment.SIZE

  private final File file;
  private final ProgressListener listener;
  private final MediaType mediaType;

  private boolean isCanceled = false;


  public CountingFileRequestBody(File file, MediaType mediaType, ProgressListener listener) {
    this.file = file;
    this.mediaType = mediaType;
    this.listener = listener;
  }

  @Override
  public long contentLength() {
    return file.length();
  }

  @Override
  public MediaType contentType() {
    return mediaType;
  }

  @Override
  public void writeTo(BufferedSink sink) throws IOException {
    Source source = null;
    try {
      source = Okio.source(file);
      long total = 0;
      long read;

      while ((read = source.read(sink.buffer(), SEGMENT_SIZE)) != -1) {
        if(isCanceled){
          throw new UploadInterruptedException("Execution canceled by user");
        }
        total += read;
        sink.flush();
        this.listener.transferred(total);

      }
    } finally {
      Util.closeQuietly(source);
    }
  }

  public void cancel() {
    isCanceled = true;
  }

  public boolean isCanceled() {
    return isCanceled;
  }

  public interface ProgressListener {
    void transferred(long num);
  }
}
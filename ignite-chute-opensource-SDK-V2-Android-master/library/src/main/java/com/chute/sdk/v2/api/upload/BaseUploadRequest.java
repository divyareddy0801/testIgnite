package com.chute.sdk.v2.api.upload;

import com.araneaapps.android.libs.asyncrunners.models.RequestOptions;
import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.MediaTypes;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.RequestMethod;
import com.dg.libs.rest.requests.RestClientRequest;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

import java.io.File;

public abstract class BaseUploadRequest extends
	RestClientRequest<ListResponseModel<AssetModel>> implements CountingFileRequestBody.ProgressListener {

	private final UploadProgressListener uploadListener;
	private final File file;
	private final CountingFileRequestBody requestBody;

	public BaseUploadRequest(String filePath,
			UploadProgressListener uploadListener,
			HttpCallback<ListResponseModel<AssetModel>> callback) {

		this.uploadListener = uploadListener;
		this.file = new File(filePath);
		this.requestBody = new CountingFileRequestBody(file, MediaTypes.OCTET_STREAM, this);
		RequestBody requestBody = new MultipartBuilder()
			.type(MultipartBuilder.FORM)
			.addFormDataPart(getMultipartEntityKey(), file.getName(), this.requestBody)
			.build();
		setRequestMethod(RequestMethod.POST, requestBody);
		setCallback(callback);
		setParser(new ListResponseParser<AssetModel>(AssetModel.class));
		setRequestOptions(new RequestOptions.RequestOptionsBuilder().setRunInSingleThread(true).build());
	}
	public abstract String getMultipartEntityKey();

	public void cancel() {
		requestBody.cancel();
	}

	@Override
	public void transferred(long num) {
		uploadListener.onProgress(file.length(), num);
	}

	@Override
	protected void doBeforeRunRequestInBackgroundThread() {
		super.doBeforeRunRequestInBackgroundThread();
		if (uploadListener != null) {
			uploadListener.onUploadStarted(file);
		}
	}

	@Override
	public void run() {
		super.run();
		if (uploadListener != null) {
			uploadListener.onUploadFinished(file);
		}
	}

}

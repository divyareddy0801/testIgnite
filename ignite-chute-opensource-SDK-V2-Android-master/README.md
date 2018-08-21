Chute-SDK-V2-Android
====================

This is the official Android SDK for www.getchute.com API version 2.


You can use it as a Maven dependency by adding the following to your list of dependencies in your pom.xml:

    <dependency>
      <groupId>com.getchute.android.sdk.v2</groupId>
      <artifactId>chute-sdk-v2-android</artifactId>
      <version>2.2.0</version>
    </dependency>


Or use the jar with dependencies from target in your regular non-maven projects.

# Changelog

## 2.4.0

  - Major update to the core libraries. The API's should be exactly the same as before as the end user of this SDK sees them. Its possible that some things will break.

## 2.3.2

  - Removed image loader from the API

## 2.2.0

	- Migrated Auth code to V2 of API
	- Added Chute.init to inititialize Chute inside the APP class

## 2.1.1

	- Removed Account Store
	- Initialization should always go through <code>Chute.init(context,authConstants); </code> A recommended way of doing this is by extending the Application class and adding this piece of code in <code>onCreate(); </code>

## 2.2.2

	- Support custom http and https handlers

## 2.2.3

	- Added License file
        
## 2.2.4

	- Clear token and auth credentials

## 2.2.5

	- Added API calls for: move/copy assets, nested albums, unlink user accounts

## 2.2.6

	- Handled authentication canceled redirect URL
	- Added API calls for key-value storage

Setup
====

1. Register AuthenticationActivity and HTTP Service in Manifest:

    ```
        <activity
            android:name="com.chute.sdk.v2.api.authentication.AuthenticationActivity"
             android:configChanges="orientation|screenSize" 
            android:theme="@android:style/Theme.Light.NoTitleBar" >
        </activity>
        <service android:name="com.dg.libs.rest.services.HTTPRequestExecutorService" />
    ```
2. Add the required permissions in the Manifest:

    ```
	<uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permission android:name="android.permission.WAKE_LOCK" />
    ```
3. Add the Client ID and Client Secret that are listed in your Chute app using the following code in the Application class:
   <pre><code>
     @Override
     public void onCreate() {
     super.onCreate();
     Chute.init(this, new AuthConstants(CLIENT_ID, CLIENT_SECRET));
  </code></pre>
	
4. Use the following code in your application to launch the Authentication screen:

    <pre><code>
         /**
          * AccountType is the type of the service you wish to authenticate to
          */
          AuthenticationFactory.getInstance().startAuthenticationActivity(
          ServicesActivity.this, AccountType.FACEBOOK);
    </code></pre>

   This will return a result in onActivityResult according to the status of the sign in.
   The Authentication token will be persisted and used from GCAccount in every request towards the Chute API.


## Request execution and callback

1. Every request can be either:  
-synchronous (it executes in the same thread as the <code>execute()</code> method was called  
-asynchronous (it executes in the Background and it is started by calling <code>executeAsync()</code>);

2. Every request can accept a suitable callback which returns an object or list depending on the response type.
3. The callback has two possible outcomes:

	<pre>
	// returns the parsed response according to the parsers return type.
	<code>public void onSuccess(T responseData); </code>
    
        // returns ResponseStatus containing HTTP status code and error message explaining the reason that caused the error to occur  
<code>public void onHttpError(ResponseStatus responseStatus); </code>
       </pre>

Basic Tasks
=========

## Uploading Assets

Use the folowing code to execute an upload request. This method needs a list of image paths to be uploaded and an album the assets to be linked to.


<pre><code>
        /** @param context
	      *            The application context
	      *  @param uploadListener
	      *            Instance of {@link UploadProgressListener} interface. 
          *  @param album
	      *            AlbumModel containing the uploaded file
          *  @param filePath
	      *            The path of the file you wish to upload 
          *  @param callback
          *            Instance of {@link HttpCallback} interface. If successful, the
	      *            callback returns {@link ListResponseModel<AssetModel>}
          */
GCAssets.uploadOneStep(context, uploadListener, album, filePath, callback).executeAsync();
</code></pre>

For progress updates include a ProgressListener that implements the UploadProgressListener Interface. 
Important note: the callback runs in the thread that is executing the request.



## Displaying Assets

The SDK includes a way to asynchronously bind photos to ImageViews.
To use this feature, you need to follow a couple of steps to include and configure the ImageLoader in your project:

1. Use and modify the folowing code inside the Application class to create an instance of the ImageLoader. The Loader uses SDcard cache with a combination of an in-memory implementation.

<pre><code>
 private static ImageLoader createImageLoader(Context context) {
	ImageLoader imageLoader = new ImageLoader(context, R.drawable.placeholder_image_small);
	imageLoader.setRequiredSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
		75, context.getResources().getDisplayMetrics()));
	return imageLoader;
    }

    private ImageLoader mImageLoader;

    @Override
    public void onCreate() {
	super.onCreate();
	mImageLoader = createImageLoader(this);
    }

    @Override
    public Object getSystemService(String name) {
	if (ImageLoader.IMAGE_LOADER_SERVICE.equals(name)) {
	    return mImageLoader;
	} else {
	    return super.getSystemService(name);
	}
    }
	</code></pre>
	
2.To use the loader for binding images first get an instance of the loader:
<pre><code>
imageLoader = ImageLoader.get(context);
</code></pre>

3.Call displayImage method providing URL, ImageView and ImageLoaderListener:

<pre><code>
        /** @param url
	      *            The image URL
	      *  @param imageView
	      *            ImageView holder
	      *  @param imageLoaderListener
	      *            Instance of {@link ImageLoaderListener} interface. 
          *  This parameter can be null if you don't need further information after 
          *  the image loads.
          */
imageLoader.displayImage(url, imageView, imageLoaderListener);	
</code></pre>

## Organizing Assets

Assets are organized in Albums.
To get all the assets for a specific album use:

<pre><code>
    /** @param context
	 *            The application context
	 *  @param album
	 *            The album containing assets you wish to retrieve
	 *  @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ListResponseModel<AssetModel>}
     */
GCAssets.list(context, album, pagination, callback).executeAsync();
</code></pre>


To create an album execute:

<pre><code>
    /** @param context
	 *             The application context
	 *  @param album
	 *             The album to be created
	 *  @param callback
	 *             Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<AlbumModel>}
	 */
 GCAlbums.create(final Context context,
			final AlbumModel album,
			final HttpCallback<ResponseModel<AlbumModel>> callback).executeAsync();
		</code></pre>
		

Social Tasks
==========

## Hearting Assets

Heart an asset:
<pre><code>
    /** @param context
	 *             The application context
	 * @param album
	 *             Album that holds the hearted asset
	 * @param asset
	 *             Hearted asset
	 * @param callback
	 *             Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<HeartModel>}
    /*
GCHearts.heart(context, album, asset, callback).executeAsync();
</code></pre>
Get a list of all hearted assets:
<pre><code>
    /** @param context
	 *             The application context
	 * @param album
	 *             Album that holds the hearted asset
	 * @param asset
	 *             Hearted asset
	 * @param callback
	 *             Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<HeartModel>}
    /*
GCHearts.get(context, album, asset, callback).executeAsync();
</code></pre>

		
## Commenting on Assets

Create a new comment:
<pre><code>
    /**
	 * @param context
	 *             The application context
	 * @param album
	 *             Album the comment belongs to
	 * @param asset
	 *             Asset the comment belongs to
	 * @param callback
	 *             Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ResponseModel<CommentModel>}
	 */
 GCComments.create(context, album, asset, comment,
				callback).executeAsync();
		</code></pre>

Get all comments for a specific asset:
<pre><code>
    /** @param context
	 *             The application context
	 *  @param album
	 *             Album containing assets with comments
	 *  @param asset
	 *             Asset containing a list of comments
	 *  @param callback
	 *             Instance of {@link HttpCallback} interface. If successful,
	 *            the callback returns {@link ListResponseModel<CommentModel>}
     */
GCComments.list(context, album, asset, callback).executeAsync();
</code></pre>

Other social tasks include handling votes, flags, tags, as well as geo location.
		
		
	

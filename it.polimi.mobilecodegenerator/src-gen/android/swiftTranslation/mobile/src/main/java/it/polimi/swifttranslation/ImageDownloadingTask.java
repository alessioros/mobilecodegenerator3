package it.polimi.swifttranslation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageDownloadingTask extends AsyncTask<ImageView, Void, Bitmap> {
	private ImageView imageView;
	private String imageUri;

	/**
	 * This task attempts to download an image from the Network:
	 * in case of success, it sets the proper ImageView,
	 * in case of failure, it does nothing (ImageView remains without image).
	 */
	public ImageDownloadingTask() {
	};

	/***
	 * Attempts to download the image from the Network.
	 * @params params[0] = ImageView where to put the image to be downloaded. The url must be attached in a tag on the ImageView.
	 */
	@Override
	protected Bitmap doInBackground(ImageView... params) {
		imageView = (ImageView) params[0];
		Bitmap bitmap = null;
		if (imageView != null) {
			imageUri = imageView.getTag().toString();
			try {
				bitmap = downloadImage(imageUri);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) { //failure in downloading the image
				e.printStackTrace();
			}
		}
		return bitmap;
	}

	/**
	 * Attempts to download the image at the url passed as parameter: it returns the bitmap in case of success, null otherwise.
	 * @param imageUrl
	 */
	protected Bitmap downloadImage(String imageUrl) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
		connection.connect();
		Bitmap downloadedBitmap = BitmapFactory.decodeStream(connection.getInputStream()); //Convert to bitmap
		connection.disconnect();
		return downloadedBitmap;
	}

	/***
	 * If the image has been downloaded properly it sets the ImageView.
	 */
	@Override
	protected void onPostExecute(Bitmap bitmap) {
		super.onPostExecute(bitmap);
		if (bitmap != null) {
			String imageUri = imageView.getTag().toString();
			if (this.imageUri.equals(imageUri)) { //needed for synchronization reasons
				this.imageView.setImageBitmap(bitmap);
			}
		}
	}
}

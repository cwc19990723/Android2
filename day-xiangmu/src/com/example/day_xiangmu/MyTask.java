package com.example.day_xiangmu;

import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

public class MyTask extends AsyncTask<String, Integer, Drawable>{
	
	ImageView guang_tu;

	public MyTask(ImageView guang_tu) {
		super();
		this.guang_tu = guang_tu;
	}


	@Override
	protected Drawable doInBackground(String... params) {
		try {
			URL url = new URL(params[0]);
			
			Drawable cre = Drawable.createFromStream(url.openStream(), "img");
			return cre;
		} catch (Exception e) {
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Drawable result) {
		super.onPostExecute(result);
		//…Ë÷√Õº∆¨
		guang_tu.setImageDrawable(result);
	}
	
}

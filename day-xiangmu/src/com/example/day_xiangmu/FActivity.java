package com.example.day_xiangmu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FActivity extends Activity implements OnClickListener{

	private ImageView f_tu;
	private Button f_ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_f);
		f_tu = (ImageView) findViewById(R.id.f_tu);
		f_ok = (Button) findViewById(R.id.f_ok);
		
		f_tu.setOnClickListener(this);
		f_ok.setOnClickListener(this);
		
	}
	
	//打开相机
	public void openxiangji(){
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 1999);
	}
	
	//打开相册
	public void openxiangce(){
		Intent intent = new Intent();
		intent.addCategory(intent.CATEGORY_OPENABLE);
		intent.setType("image/*");
		intent.setAction(intent.ACTION_OPEN_DOCUMENT);
		startActivityForResult(intent, 2017);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//相册
		if(requestCode==RESULT_OK &&resultCode==2017){
			
			Bitmap bm = (Bitmap) data.getExtras().get("data");
			f_tu.setImageBitmap(bm);
		}
		//相机
		if(requestCode==RESULT_OK &&resultCode==1999){
		
			Uri uri = data.getData();
			f_tu.setImageURI(uri);
		}
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.f_tu:
			tu();
			break;
		case R.id.f_ok:
			ok();
			break;

		default:
			break;
		}
	}

	private void ok() {
		startActivity(new Intent(FActivity.this,EActivity.class));
	}

	private void tu() {
		new AlertDialog.Builder(this).setTitle("设置头像")
		.setPositiveButton("相机", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
					
				openxiangji();
			}
		})
		.setNegativeButton("相册", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
					
			}
		}).create().show();
	}
}

package com.example.day_xue_xiangmu;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;

public class Xiugaiziliao extends Activity {

	private EditText ziliao_name;
	private RadioButton ziliao_nan;
	private RadioButton ziliao_nv;
	private Button ok;
	private EditText ziliao_shengri;
	private RatingBar ziliao_rb;
	private ImageView tu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xiugaiziliao);
		
		ziliao_name = (EditText) findViewById(R.id.ziliao_name);
		ziliao_nan = (RadioButton) findViewById(R.id.ziliao_nan);
		ziliao_nv = (RadioButton) findViewById(R.id.ziliao_nv);
		ok = (Button) findViewById(R.id.ziliao_queren);
		ziliao_shengri = (EditText) findViewById(R.id.ziliao_shengri);
		ziliao_rb = (RatingBar) findViewById(R.id.ziliao_rb);
		
		tu = (ImageView) findViewById(R.id.ziliao_tu);
		
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				String name = ziliao_name.getText().toString();
				String nan = ziliao_nan.getText().toString();
				String nv = ziliao_nv.getText().toString();
				String shengri = ziliao_shengri.getText().toString();
				int rb = ziliao_rb.getTextAlignment();
				
				in.putExtra("name", name);
				in.putExtra("sex", nan);
				in.putExtra("sex", nv);
				in.putExtra("shengri", shengri);
				in.putExtra("dengji", String.valueOf(rb));
				
				setResult(200, in);
				finish();
			}
		});
		
		//图
		tu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog dialog = new AlertDialog.Builder(Xiugaiziliao.this).setTitle("设置头像")
				.setPositiveButton("相机", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
						startActivityForResult(intent, 1999);
					}
				})
				.setNegativeButton("相册", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//打开相册
						Intent intent = new Intent();
						intent.addCategory(intent.CATEGORY_OPENABLE);
						intent.setType("image/*");
						intent.setAction(intent.ACTION_OPEN_DOCUMENT);
						startActivityForResult(intent, 2017);
					}
				})
				.create();dialog.show();
			}
		});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//相册
				if(requestCode==RESULT_OK &&resultCode==2017){
					
					Bitmap bm = (Bitmap) data.getExtras().get("data");
					tu.setImageBitmap(bm);
				}
				//相机
				if(requestCode==RESULT_OK &&resultCode==1999){
				
					Uri uri = data.getData();
					tu.setImageURI(uri);
				}
		
	}
	
}

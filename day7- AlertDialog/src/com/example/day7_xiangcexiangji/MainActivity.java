package com.example.day7_xiangcexiangji;

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

public class MainActivity extends Activity implements OnClickListener {

	private ImageView a_tu;
	private Button a_an;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_tu = (ImageView) findViewById(R.id.a_tu);
		a_an = (Button) findViewById(R.id.a_an);
		
		a_tu.setOnClickListener(this);
		a_an.setOnClickListener(this);
		
	}
	
	//���������
	public void openxiangji(){
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 1999);
	}
	//��������
	public void openxiangce(){
		Intent is = new Intent();
		is.addCategory(is.CATEGORY_OPENABLE);
		is.setType("image/*");
		is.setAction(is.ACTION_OPEN_DOCUMENT);
		startActivityForResult(is, 2018);
	}
	//��ûش�����
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//������
		if(requestCode==RESULT_OK &&resultCode==2018){
			
			Bitmap bm = (Bitmap) data.getExtras().get("data");
			a_tu.setImageBitmap(bm);
			
		}
		//�������
		if(requestCode==RESULT_OK&&resultCode==1999){
			
			Uri uri = data.getData();
			a_tu.setImageURI(uri);
		}
	}
	
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.a_tu:
			tu();
			break;
		case R.id.a_an:
			an();
			break;

		default:
			break;
		}
		
	}

	private void an() {
		new AlertDialog.Builder(this).setTitle("����")
		.setPositiveButton("���", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				openxiangji();
				
			}
		})
		.setNegativeButton("���", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				openxiangce();
				
			}
		})
		.create().show();
	}

	private void tu() {
		
	}
	
}

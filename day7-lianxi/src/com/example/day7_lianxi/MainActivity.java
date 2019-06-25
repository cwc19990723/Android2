package com.example.day7_lianxi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	private Button a_bt;
	private EditText a_ed;
	private String phone;
	private ImageView a_tu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a_bt = (Button) findViewById(R.id.a_bt);
		a_ed = (EditText) findViewById(R.id.a_ed);
		a_tu = (ImageView) findViewById(R.id.a_tu);
		
		a_bt.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		openxiangji();
	}
		
	
	//发短信
	public void faduanxin(){
		phone = a_ed.getText().toString(); 
		Uri uri = Uri.parse("smsto:"+phone);
		Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
		startActivity(intent);
	}
	//打电话
	public void callphone(){
		/*Intent intent = new Intent();
		intent.setAction(intent.ACTION_DIAL);
		intent.setData(Uri.parse("smsto:15733247087"));
		startActivity(intent);*/
		Uri uri = Uri.parse("tel:"+phone);
		Intent intent = new Intent(Intent.ACTION_DIAL,uri);
		startActivity(intent);
	}
	
	//打开相机
	public void openxiangji(){
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 1999);
	}
	
	//接受回传方法
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
										//RESULT_OK是已经写好的调用就行
		if(requestCode==1999&&resultCode==RESULT_OK){
			Uri rui = data.getData();
			a_tu.setImageURI(rui);
		}
	}
	
	
}

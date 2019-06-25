package com.zhuan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
		
	
	private ProgressBar zhuan3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danxuan);
		//找到单选组
		RadioGroup sex = (RadioGroup) findViewById(R.id.sex);
		//为单选组对象设置单选项发生改变的监听事件
		sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
			
				Toast.makeText(MainActivity.this, "单选按钮发生改变了", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
		//获取复选框对象,设置监听事件
		CheckBox lanqiu = (CheckBox) findViewById(R.id.lanqiu);
		//为复选框设置监听事件
		lanqiu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		//
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
				Toast.makeText(MainActivity.this, "篮球发生改变", Toast.LENGTH_SHORT).show();
				}else {
				Toast.makeText(MainActivity.this, "篮球没有发生改变", Toast.LENGTH_SHORT).show();
				}
			}
		});
		zhuan3 = (ProgressBar)findViewById(R.id.zhuan3);
	}
	
	public void addprogress(View v){
		//通过Progress对象，增加进度
		zhuan3.incrementProgressBy(10);
		//通过Progress对象，增加第二进度
		zhuan3.incrementSecondaryProgressBy(10);
	}
	
}

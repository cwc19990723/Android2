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
		//�ҵ���ѡ��
		RadioGroup sex = (RadioGroup) findViewById(R.id.sex);
		//Ϊ��ѡ��������õ�ѡ����ı�ļ����¼�
		sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
			
				Toast.makeText(MainActivity.this, "��ѡ��ť�����ı���", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
		//��ȡ��ѡ�����,���ü����¼�
		CheckBox lanqiu = (CheckBox) findViewById(R.id.lanqiu);
		//Ϊ��ѡ�����ü����¼�
		lanqiu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		//
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
				Toast.makeText(MainActivity.this, "�������ı�", Toast.LENGTH_SHORT).show();
				}else {
				Toast.makeText(MainActivity.this, "����û�з����ı�", Toast.LENGTH_SHORT).show();
				}
			}
		});
		zhuan3 = (ProgressBar)findViewById(R.id.zhuan3);
	}
	
	public void addprogress(View v){
		//ͨ��Progress�������ӽ���
		zhuan3.incrementProgressBy(10);
		//ͨ��Progress�������ӵڶ�����
		zhuan3.incrementSecondaryProgressBy(10);
	}
	
}

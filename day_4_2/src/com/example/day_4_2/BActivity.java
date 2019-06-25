package com.example.day_4_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BActivity extends Activity {

	private Button nihao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		nihao = (Button) findViewById(R.id.b_nihao);
		
		nihao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog dialog = new AlertDialog.Builder(BActivity.this)
				.setTitle("��������")
				.setMessage("��������,��֪��ǰ״̬,��Ϣ�ͽ������,�������־�����������������")
				.setPositiveButton("������", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(BActivity.this, "��ð�", Toast.LENGTH_SHORT).show();
					}
				})
				.setNegativeButton("��������", null)
				.create();dialog.show();
			}
		});
	}
}

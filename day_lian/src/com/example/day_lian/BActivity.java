package com.example.day_lian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BActivity extends Activity implements OnClickListener {

	private CheckBox lq;
	private CheckBox zq;
	private CheckBox ymq;
	private TextView ah;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);
		
		lq = (CheckBox) findViewById(R.id.b_lq);
		zq = (CheckBox) findViewById(R.id.b_zq);
		ymq = (CheckBox) findViewById(R.id.b_ymq);
		ah = (TextView) findViewById(R.id.b_ah);
		
		lq.setOnClickListener(this);
		zq.setOnClickListener(this);
		ymq.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b_lq:
			Toast.makeText(BActivity.this, "Œ“œ≤ª∂¿∫«Ú", Toast.LENGTH_SHORT).show();
			break;
		case R.id.b_zq:
			Toast.makeText(BActivity.this, "Œ“œ≤ª∂◊„«Ú", Toast.LENGTH_SHORT).show();
			break;
		case R.id.b_ymq:
			Toast.makeText(BActivity.this, "Œ“œ≤ª∂”√´«Ú", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}

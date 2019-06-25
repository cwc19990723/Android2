package com.example.day_xiangmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class FGaiActivity extends Activity implements OnClickListener{

	private ImageButton fgai_an1;
	private Button fgai_ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_f_gai);
		
		fgai_an1 = (ImageButton) findViewById(R.id.fgai_an1);
		fgai_ok = (Button) findViewById(R.id.fgai_ok);
		
		fgai_an1.setOnClickListener(this);
		fgai_ok.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fgai_an1:
			xiugai();
			break;
		case R.id.fgai_ok:
			ok();
			break;

		default:
			break;
		}
	}

	private void ok() {
		startActivity(new Intent(FGaiActivity.this,EActivity.class));
	}

	private void xiugai() {
		startActivity(new Intent(FGaiActivity.this,EActivity.class));
	}
}

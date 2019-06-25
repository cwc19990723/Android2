package com.example.day_xiangmu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;import android.transition.TransitionValues;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class RuanjianshiyongActivity<E> extends Activity implements OnClickListener {

	private ListView ruanjian_lie;
	private EditText ed;
	private ShiyongAdapter adapter;
	private Button fasong;
	private ArrayList<Travel> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ruanjianshiyong);
		
		ruanjian_lie = (ListView) findViewById(R.id.ruanjian_lie);
		al = new ArrayList<Travel>();
		ed = (EditText) findViewById(R.id.ruanjian_ed);
		fasong = (Button) findViewById(R.id.ruanjian_fasong);
		
		List<Travel> list = initData();
		//ÕÒµ½ÊÊÅäÆ÷
		adapter = new ShiyongAdapter(this, al);
		//°ó¶¨ÊÊÅäÆ÷
		ruanjian_lie.setAdapter(adapter);
		
		ed.setOnClickListener(this);
		fasong.setOnClickListener(this);
	}

	private List<Travel> initData() {
		al.add(new Travel(R.drawable.a, "Æ»¹û"));
		al.add(new Travel(R.drawable.b, "Ïã½¶"));
		al.add(new Travel(R.drawable.c, "éÙ×Ó"));
		al.add(new Travel(R.drawable.d, "Î÷¹Ï"));
		return al;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ruanjian_ed:
			
			break;
		case R.id.ruanjian_fasong:
			fasong();
			
			break;

		default:
			break;
		}
	}

	private void fasong() {
		String edt = ed.getText().toString();
		Travel travel = new Travel();
		travel.setName(edt);
		al.add(travel);
		adapter.notifyDataSetChanged();
	}
}

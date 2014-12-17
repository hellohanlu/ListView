package com.vince.android_021;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView01);
		lv.setOnItemClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//ListView的列表项的单击事件
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		System.out.println("parent = "+parent.getClass());
		System.out.println("view = "+view.getClass());
		
		TextView tv = (TextView)view;
		Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
		
		
		System.out.println("position = "+position);
		System.out.println("id = "+id);
		
	}

}






















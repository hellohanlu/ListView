package com.vince.android_021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity4 extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main4);
		lv = (ListView) findViewById(R.id.listView1);

		// 一个列表项内容
		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put("image", R.drawable.jsb_j);
		item1.put("name", "小白白");

		// 一个列表项内容
		Map<String, Object> item2 = new HashMap<String, Object>();
		item2.put("image", R.drawable.jsb_j);
		item2.put("name", "小黑黑");
		
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		data.add(item1);
		data.add(item2);

		SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.main4_item,
				new String[]{"image","name"}, new int[]{R.id.imageView1,R.id.textView1});
		
		lv.setAdapter(sa);
	}
}

















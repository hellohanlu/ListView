package com.vince.android_021;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity3 extends Activity implements OnItemClickListener{
	
	private ListView lv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main3);
		lv = (ListView) findViewById(R.id.listView1);
		
		String[] citys = {"����","�Ϻ�","����","����"};
		
		//��ѡ
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,citys);
		//��ѡ
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,citys);
		
		//����Ϊ��ѡģʽ
//		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		//����Ϊ��ѡģʽ
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(this);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		System.out.println(view.getClass());
	}
}













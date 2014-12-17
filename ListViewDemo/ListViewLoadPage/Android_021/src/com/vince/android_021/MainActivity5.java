package com.vince.android_021;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity5 extends Activity {
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main5);
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new MyAdapter());

	}

	// ���������
	private int[] images = { R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j, R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j, R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j, R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j };
	private String[] names = { "С����", "С�ƻ�", "С�װ�", "С�ں�", "С����2", "С�ƻ�2",
			"С�װ�2", "С�ں�2", "С����3", "С�ƻ�3", "С�װ�3", "С�ں�3" };

	// �Զ���������
	class MyAdapter extends BaseAdapter {
		// ��ȡ�б��������
		@Override
		public int getCount() {
			return names.length;
		}

		// ��ȡÿһ���б���
		@Override
		public Object getItem(int position) {
			return names[position];
		}

		// ��ȡÿ���б����ID
		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
//			System.out.println("position=" + position);
//			System.out.println(convertView);
//			System.out.println("------------------------");
			if(convertView==null){
				//����View
				convertView = getLayoutInflater().inflate(R.layout.main5_item, null);
				ViewHolder vh = new ViewHolder();
				vh.iv = (ImageView) convertView.findViewById(R.id.imageView1);
				vh.tv = (TextView) convertView.findViewById(R.id.textView1);
				convertView.setTag(vh);
				vh.iv.setImageResource(images[position]);
				vh.tv.setText(names[position]);
			}else{
				ViewHolder vh = (ViewHolder)convertView.getTag();
				vh.iv.setImageResource(images[position]);
				vh.tv.setText(names[position]);
			}
//			System.out.println(convertView);
//			ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
//			TextView tv = (TextView) convertView.findViewById(R.id.textView1);

//			iv.setImageResource(images[position]);
//			tv.setText(names[position]);

			return convertView;
		}

	}
	
	
	static class ViewHolder{
		ImageView iv;
		TextView tv;
	}

}






















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

	// 定义的数据
	private int[] images = { R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j, R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j, R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j, R.drawable.jsb_j, R.drawable.jsb_j,
			R.drawable.jsb_j };
	private String[] names = { "小花花", "小黄黄", "小白白", "小黑黑", "小花花2", "小黄黄2",
			"小白白2", "小黑黑2", "小花花3", "小黄黄3", "小白白3", "小黑黑3" };

	// 自定义适配器
	class MyAdapter extends BaseAdapter {
		// 获取列表项的总数
		@Override
		public int getCount() {
			return names.length;
		}

		// 获取每一个列表项
		@Override
		public Object getItem(int position) {
			return names[position];
		}

		// 获取每个列表项的ID
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
				//创建View
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






















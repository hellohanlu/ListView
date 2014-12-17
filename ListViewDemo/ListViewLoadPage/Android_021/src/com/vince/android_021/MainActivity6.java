package com.vince.android_021;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity6 extends Activity implements OnScrollListener{

	private ListView lv;
	Vector<News> news = new Vector<News>();
	MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main6);
		lv = (ListView) findViewById(R.id.listView1);
		
		lv.setOnScrollListener(this);
		//设置底部视图
		View footer = getLayoutInflater().inflate(R.layout.load, null);
		lv.addFooterView(footer);
		
//		initData();
		new LoadDataThread().start();//加载数据的工作线程
		
		adapter = new MyAdapter();
		lv.setAdapter(adapter);
	}
	
	
	
	
	int index = 1;//数据的记数器(索引)
	//初始化数据
	void initData(){
		for (int i = 0; i < 10; i++) {
			News n = new News();
			n.title = "title-"+index;
			n.content = "content-"+ index;
			index++;
			news.add(n);
 		}
	}
	
	//自定义适配器
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return news.size();
		}

		@Override
		public Object getItem(int position) {
			return news.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder vh = null;
			if(convertView==null){
				convertView = getLayoutInflater().inflate(R.layout.main6_item, null);
				vh = new ViewHolder();
				vh.tvTitle = (TextView) convertView.findViewById(R.id.textView1_title);
				vh.tvContent = (TextView) convertView.findViewById(R.id.textView2_content);
				convertView.setTag(vh);
			}else{
				vh = (ViewHolder) convertView.getTag();
			}
			//从Vector中取出数据填充到ListView列表项中
			News n = news.get(position);
			vh.tvTitle.setText(n.title);
			vh.tvContent.setText(n.content);
			
			return convertView;
		}
		
	}
	
	static class ViewHolder{
		TextView tvTitle;
		TextView tvContent;
	}

//	int scrollState = 0;
	int visibleLastIndex = 0;
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
//		this.scrollState = scrollState;
//		System.out.println("scrollState="+scrollState);
		if(visibleLastIndex==adapter.getCount() && scrollState==OnScrollListener.SCROLL_STATE_IDLE){
			new LoadDataThread().start();
		}
	}

	
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
//		System.out.println("firstVisibleItem="+firstVisibleItem);
//		System.out.println("visibleItemCount="+visibleItemCount);
//		System.out.println("totalItemCount="+totalItemCount);
		
		visibleLastIndex = firstVisibleItem+visibleItemCount-1;
	}
	
	//线程之间通信的桥梁
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				//通知适配器，更新数据列表
				adapter.notifyDataSetChanged();
				break;

			default:
				break;
			}
		}
	};
	
	//模拟加载数据
	//子线程不允许访问主线程的UI组件(保正主线程UI组件安全)
	class LoadDataThread extends Thread{
		@Override
		public void run() {
			initData();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//通过handler处理器去通知主线程，说数据已加载完毕
			handler.sendEmptyMessage(1);
		}
	}

}














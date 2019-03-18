package com.jarppy.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 活动中不显示标题栏
		setContentView(R.layout.first_layout);
		
		Button button1 = (Button) findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() { // 调用 setOnClickListener()方法为按钮注册一个监听器，点击按钮时就会执行监听器中的 onClick()方法。
			public void onClick(View v) {
				Toast.makeText(FirstActivity.this, "You clicked Button 1",
						Toast.LENGTH_SHORT).show(); // 显示 点击后的toast提示消息
			}
		});
	}
	
	/**
	 * 重写onCreateOptionsMenu()
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu); //  getMenuInflater()方法能够得到 MenuInflater对象，再调用它的 inflate()方法就可以给当前活动创建菜单了
		return true; // 返回 true，表示允许创建的菜单显示出来，如果返回了 false，创建的菜单将无法显示。
	}
	
	/**
	 * 重写onOptionsItemSelected()方法
	 */
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) { //  item.getItemId()来判断我们点击的是哪一个菜单项
			case R.id.add_item:
				Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
				break;
			case R.id.remove_item:
				Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
				break;
			default:
		}
		return true;
	}
}

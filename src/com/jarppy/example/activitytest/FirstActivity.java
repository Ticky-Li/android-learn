package com.jarppy.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
				// Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show(); // 点击后 显示toast提示消息
				
				// finish(); // 2.2.7 销毁一个活动
				
				// 使用显式 Intent
				// Intent intent = new Intent(FirstActivity.this, SecondActivity.class);  // 在 FirstActivity 这个活动的基础上打开 SecondActivity 这个活动。
				// startActivity(intent); // 然后通过 startActivity()方法来执行这个 Intent。按下 Back 键就可以销毁当前活动，从而回到上一个活动了
				
				// 使用隐式 Intent。 AndroidManifest.xml 里面修改的  <action>，在这启动
//				 使用隐式 Intent，还可以启动其他程序的活动，这使 Android 多个应用程序之间的功能可以共享。
//				 Intent intent = new Intent("com.example.activitytest.ACTION_START");
//				 startActivity(intent);
				 
				
				// 新增 category
//				Intent intent = new Intent("com.example.activitytest.ACTION_START");
//				intent.addCategory("com.example.activitytest.MY_CATEGORY"); // 注意AndroidManifest.xml 里面添加 category
//				startActivity(intent);
				
				// Intent 打开 浏览器程序 Intent.ACTION_VIEW
//				Intent intent = new Intent(Intent.ACTION_VIEW); // Intent.ACTION_VIEW是 Android 系统内置的动作，其常量值为 android.intent.action.VIEW
//				intent.setData(Uri.parse("http://www.baidu.com")); // Uri.parse()方法，将一个网址字符串解析成一个 Uri 对象，再调用 Intent的 setData()方法将这个 Uri 对象传递进去。
//				startActivity(intent);
				
				// Intent 拨打电话 Intent.ACTION_DIAL
//				Intent intent = new Intent(Intent.ACTION_DIAL);
//				intent.setData(Uri.parse("tel:10086"));
//				startActivity(intent);
				
				// 2.3.4 向下一个活动传递数据。FirstActivity 中有一个字符串，现在想把这个字符串传递到SecondActivity 中
//				String data = "Hello SecondActivity";
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				intent.putExtra("extra_data", data);
//				startActivity(intent);
				
				// 2.3.5 返回数据给上一个活动（接收）
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivityForResult(intent, 1);
				
			}
		});
	}
	
	/**
	 * 由于我们是使用 startActivityForResult()方法来启动 SecondActivity 的，
	 * 在 SecondActivity被销毁之后会回调上一个活动的 onActivityResult()方法，
	 * 因此我们需要在 FirstActivity 中重写这个方法来得到返回的数据
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if(resultCode == RESULT_OK) {
				String returnedData =  data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
			}
			break;
		default:
		}
	}



	/**
	 * 2.2.6 在活动中使用 Menu
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

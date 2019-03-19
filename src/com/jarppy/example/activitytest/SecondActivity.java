package com.jarppy.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		// 接收上一个活动传送过来的数据 （接收）
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data"); //  getStringExtra()方法来获取传递的数据。整型数据，使用getIntExtra()方法；布尔型数据，使用 getBooleanExtra()方法，以此类推。
//		Log.d("SecondActivity", data);
		
		// 2.3.5 返回数据给上一个活动（返回）
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello FirstActivity");
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}

	/**
	 * 通过按下 Back 键回到 FirstActivity
	 */
	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello FirstActivity");
		setResult(RESULT_OK, intent);
		finish();
	}
	
	
}

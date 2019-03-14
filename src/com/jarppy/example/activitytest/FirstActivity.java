package com.jarppy.example.activitytest;

import com.jarppy.example.helloworld.R;

import android.app.Activity;
import android.os.Bundle;
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
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() { // 监听 id=button1,按钮的点击事件
			public void onClick(View v) {
				Toast.makeText(FirstActivity.this, "You clicked Button 1",
						Toast.LENGTH_SHORT).show(); // 显示 点击后的toast提示消息
			}
		});
	}
}

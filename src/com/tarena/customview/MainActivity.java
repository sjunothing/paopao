package com.tarena.customview;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
CustomView customView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		customView=(CustomView) findViewById(R.id.customView);
		customView.setData(getData());
		
	}
	
	//9: 3000
	//10: 4000
	//11: 5000
	//13:4800
	//arrayList<hashMap>
	public ArrayList<HashMap<String,String>> getData()
	{
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

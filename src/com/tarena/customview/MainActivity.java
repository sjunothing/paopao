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
	
		
	}
	
	//9: 3000
	//10: 4000
	//11: 5000
	//13:4800
	//arrayList<hashMap>
	public ArrayList<HashMap<String,String>> getData()
	{
		ArrayList<HashMap<String,String>> list=new ArrayList();
		HashMap<String,String> map1=new HashMap();
		map1.put("time", "9");
		map1.put("price", "3000");
		list.add(map1);
		
		map1=new HashMap();
		map1.put("time", "10");
		map1.put("price", "4000");
		list.add(map1);
		
		map1=new HashMap();
		map1.put("time", "11");
		map1.put("price", "5000");
		list.add(map1);
		
		map1=new HashMap();
		map1.put("time", "13");
		map1.put("price", "4800");
		list.add(map1);
		
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

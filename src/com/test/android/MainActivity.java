package com.test.android;

import java.util.Hashtable;

import com.test.android.service.Organism;
import com.test.android.service.Service;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private Service server = new Service() ;
	private Hashtable<Integer,Hashtable<Integer,Organism>> table = new Hashtable<Integer,Hashtable<Integer,Organism>>() ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.init() ;
	}
	//初始化画面
	private void init() {
		ImageView image = (ImageView)findViewById(R.id.imageView11);
		this.initImage(image, 1, 1) ;
		image = (ImageView)findViewById(R.id.imageView12);
		this.initImage(image, 1, 2) ;
		image = (ImageView)findViewById(R.id.imageView13);
		this.initImage(image, 1, 3) ;
		image = (ImageView)findViewById(R.id.imageView14);
		this.initImage(image, 1, 4) ;
		image = (ImageView)findViewById(R.id.imageView15);
		this.initImage(image, 1, 5) ;
		image = (ImageView)findViewById(R.id.imageView16);
		this.initImage(image, 1, 6) ;
		
		image = (ImageView)findViewById(R.id.imageView21);
		this.initImage(image, 2, 1) ;
		image = (ImageView)findViewById(R.id.imageView22);
		this.initImage(image, 2, 2) ;
		image = (ImageView)findViewById(R.id.imageView23);
		this.initImage(image, 2, 3) ;
		image = (ImageView)findViewById(R.id.imageView24);
		this.initImage(image, 2, 4) ;
		image = (ImageView)findViewById(R.id.imageView25);
		this.initImage(image, 2, 5) ;
		image = (ImageView)findViewById(R.id.imageView26);
		this.initImage(image, 2, 6) ;

		image = (ImageView)findViewById(R.id.imageView31);
		this.initImage(image, 3, 1) ;
		image = (ImageView)findViewById(R.id.imageView32);
		this.initImage(image, 3, 2) ;
		image = (ImageView)findViewById(R.id.imageView33);
		this.initImage(image, 3, 3) ;
		image = (ImageView)findViewById(R.id.imageView34);
		this.initImage(image, 3, 4) ;
		image = (ImageView)findViewById(R.id.imageView35);
		this.initImage(image, 3, 5) ;
		image = (ImageView)findViewById(R.id.imageView36);
		this.initImage(image, 3, 6) ;

		image = (ImageView)findViewById(R.id.imageView41);
		this.initImage(image, 4, 1) ;
		image = (ImageView)findViewById(R.id.imageView42);
		this.initImage(image, 4, 2) ;
		image = (ImageView)findViewById(R.id.imageView43);
		this.initImage(image, 4, 3) ;
		image = (ImageView)findViewById(R.id.imageView44);
		this.initImage(image, 4, 4) ;
		image = (ImageView)findViewById(R.id.imageView45);
		this.initImage(image, 4, 5) ;
		image = (ImageView)findViewById(R.id.imageView46);
		this.initImage(image, 4, 6) ;

		image = (ImageView)findViewById(R.id.imageView51);
		this.initImage(image, 5, 1) ;
		image = (ImageView)findViewById(R.id.imageView52);
		this.initImage(image, 5, 2) ;
		image = (ImageView)findViewById(R.id.imageView53);
		this.initImage(image, 5, 3) ;
		image = (ImageView)findViewById(R.id.imageView54);
		this.initImage(image, 5, 4) ;
		image = (ImageView)findViewById(R.id.imageView55);
		this.initImage(image, 5, 5) ;
		image = (ImageView)findViewById(R.id.imageView56);
		this.initImage(image, 5, 6) ;

		image = (ImageView)findViewById(R.id.imageView61);
		this.initImage(image, 6, 1) ;
		image = (ImageView)findViewById(R.id.imageView62);
		this.initImage(image, 6, 2) ;
		image = (ImageView)findViewById(R.id.imageView63);
		this.initImage(image, 6, 3) ;
		image = (ImageView)findViewById(R.id.imageView64);
		this.initImage(image, 6, 4) ;
		image = (ImageView)findViewById(R.id.imageView65);
		this.initImage(image, 6, 5) ;
		image = (ImageView)findViewById(R.id.imageView66);
		this.initImage(image, 6, 6) ;
	}
	//初始化单元画面
	private void initImage(ImageView image, int x, int y){
		//加事件
		image.setOnClickListener(new NewImageListener(x, y)) ;
		
		//记录下位置状态等
		Organism org = new Organism(x, y, image) ;
		Hashtable<Integer,Organism> row = table.get(x) ;
		if(row==null){
			row = new Hashtable<Integer,Organism>() ;
			table.put(x, row);
		}
		row.put(y, org) ;
	}

	private void btOnclick(int x, int y) {
		Organism org = table.get(x).get(y) ;
		
		if(org.getLeve()>0){
//			new AlertDialog.Builder()
			return ;
		}
		server.change(table, x, y, 1, 0) ;
	}

	class NewImageListener implements Button.OnClickListener{
		private int x, y ;
		public NewImageListener(int x, int y){
			this.x = x ;
			this.y = y ;
		}
		@Override
		public void onClick(View v) {
			btOnclick(x, y) ;
		}
		
	}
}

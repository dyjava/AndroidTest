package com.test.android.service;

import com.test.android.R;

import android.widget.ImageView;


/**
 * 生物体
 * @author Administrator
 *
 */
public class Organism {

	private int type = 0 ;		//类型： 植物 0， 动物 1 
	private int leve = 0 ;		//等级
	private int x ;				//x坐标
	private int y ;				//y坐标

	private ImageView image ;		//
	
	public Organism(int x,int y,ImageView image){
		this(x, y, 0, image) ;
	}
	
	public Organism(int x,int y,int leve,ImageView image){
		this.x = x ;
		this.y = y ;
		this.leve = leve ;
		this.image = image ;
		
		this.setLabel() ;
	}

	public int change(int leve){
		this.leve = leve ;
		
		this.setLabel() ;
		return 0 ;
	}
	public int change(int leve, int type){
		this.leve = leve ;
		this.type = type ;
		
		this.setLabel() ;
		return 0 ;
	}

	private void setLabel() {
		int r = R.drawable.zw_01 ;
		
		if(type==0){
			switch (leve){
				case 1 : r=R.drawable.zw_01 ;break ;
				case 2 : r=R.drawable.zw_02 ;break ;
				case 3 : r=R.drawable.zw_03 ;break ;
				case 4 : r=R.drawable.zw_04 ;break ;
				default : r=R.drawable.zw_00 ;this.leve = 0 ;
			}
		}
		
		image.setImageResource(r) ;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLeve() {
		return leve;
	}
	public void setLeve(int leve) {
		this.leve = leve;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ImageView getImage() {
		return image;
	}
	public void setImage(ImageView image) {
		this.image = image;
	}
	
}

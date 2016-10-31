package com.tarena.customview;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

//继承之view或view的子类就是自定义控件
public class CustomView extends View {

	int viewWidth, viewHeight;
	ArrayList<HashMap<String, String>> list;

	int gap;
	int maxPrice;

	// 构选方法要两个参数Attribute属性
	// 一个参数不能用，没有属性信息
	// public CustomView(Context context) {
	// super(context);
	// }
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	// 接收数据
	public void setData(ArrayList<HashMap<String, String>> list) {
		this.list = list;
		for (int i=0;i<list.size();i++)
		{
			int currentPrice=Integer.parseInt(list.get(i).get("price"));
			if (currentPrice>maxPrice)
			{
				maxPrice=currentPrice;
			}
		}
	}

	// 绘制界面
	@Override
	protected void onDraw(Canvas canvas) {
		// 画背景
		// 设置字号,color
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);

		// 画矩形
		Rect rect = new Rect(0, 0, viewWidth, viewHeight);

		// 画图形，文字，图片
		canvas.drawRect(rect, paint);
		// 得最后时间的宽度
		// 设置字号，单位是px
		paint.setTextSize(48);

		String lastTime = list.get(list.size() - 1).get("time");
		Rect lastTimeSizeRect = new Rect();
		// 矩形的大小就是文字的大小
		paint.getTextBounds(lastTime, 0, lastTime.length(), lastTimeSizeRect);
		int lastTimeWidth = lastTimeSizeRect.width();

		gap = (viewWidth - lastTimeWidth) / (list.size() - 1);
		// 画时间
		paint.setColor(Color.WHITE);
		int priceHeight=viewHeight-lastTimeSizeRect.height();

		for (int i = 0; i < list.size(); i++) {
			HashMap<String, String> map = list.get(i);
			String time = map.get("time");
			int timeX = gap * i;
			canvas.drawText(time, timeX, viewHeight, paint);
			//画价格
			int currentPrice=Integer.parseInt(map.get("price"));
			//int 3000/5000=0
			//推荐数据类型用double
			int priceY=currentPrice*priceHeight/maxPrice;
			//值越大，显示在下面，应该显示在上面
			priceY=priceHeight-priceY;
			
			//最大的值显示在控件的外面
			priceY=priceY+lastTimeSizeRect.height();
			
			canvas.drawText(map.get("price"), timeX, priceY, paint);
		}

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		viewHeight = h;
		viewWidth = w;
	}

}

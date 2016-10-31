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

//�̳�֮view��view����������Զ���ؼ�
public class CustomView extends View {

	int viewWidth, viewHeight;
	ArrayList<HashMap<String, String>> list;

	int gap;
	int maxPrice;

	// ��ѡ����Ҫ��������Attribute����
	// һ�����������ã�û��������Ϣ
	// public CustomView(Context context) {
	// super(context);
	// }
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	// ��������
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

	// ���ƽ���
	@Override
	protected void onDraw(Canvas canvas) {
		// ������
		// �����ֺ�,color
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);

		// ������
		Rect rect = new Rect(0, 0, viewWidth, viewHeight);

		// ��ͼ�Σ����֣�ͼƬ
		canvas.drawRect(rect, paint);
		// �����ʱ��Ŀ��
		// �����ֺţ���λ��px
		paint.setTextSize(48);

		String lastTime = list.get(list.size() - 1).get("time");
		Rect lastTimeSizeRect = new Rect();
		// ���εĴ�С�������ֵĴ�С
		paint.getTextBounds(lastTime, 0, lastTime.length(), lastTimeSizeRect);
		int lastTimeWidth = lastTimeSizeRect.width();

		gap = (viewWidth - lastTimeWidth) / (list.size() - 1);
		// ��ʱ��
		paint.setColor(Color.WHITE);
		int priceHeight=viewHeight-lastTimeSizeRect.height();

		for (int i = 0; i < list.size(); i++) {
			HashMap<String, String> map = list.get(i);
			String time = map.get("time");
			int timeX = gap * i;
			canvas.drawText(time, timeX, viewHeight, paint);
			//���۸�
			int currentPrice=Integer.parseInt(map.get("price"));
			//int 3000/5000=0
			//�Ƽ�����������double
			int priceY=currentPrice*priceHeight/maxPrice;
			//ֵԽ����ʾ�����棬Ӧ����ʾ������
			priceY=priceHeight-priceY;
			
			//����ֵ��ʾ�ڿؼ�������
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

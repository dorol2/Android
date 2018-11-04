package com.example.dorol.notepad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import org.xml.sax.Attributes;

public class MultiTouchView extends View {

    private static final int SIZE = 60;

    final int MAX_POINTS = 10;
    float[] x = new float[MAX_POINTS];
    float[] y = new float[MAX_POINTS];
    boolean[] touching = new boolean[MAX_POINTS];

    private Paint mPaint;

    public MultiTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // 터치 순서 : 앞부분의 터치가 떨어지고 그 다음에 터치하는 것의 수는 앞부터 채워진다.
        int index = event.getActionIndex();
        //Log.d("getActionIndex", String.valueOf(index));

        //터치 아이디 : 앞부분의 터치가 떨어지고 그 다음에 터치하는 것의 수는 앞부터 채워진다.
        int id = event.getPointerId(index);
        //Log.d("getPointerId", String.valueOf(id));

        //포인터의 인덱스를 제외한 액션 번호( ACTION_DOWN or ACTION_POINTER_DOWN 과 같은)
        int action = event.getActionMasked();
        //Log.d("getActionMasked", String.valueOf(action));

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                x[id] = (int) event.getX(index);
                y[id] = (int) event.getY(index);
                touching[id] = true;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                touching[id] = false;
                break;
        }

        invalidate();//화면 갱신
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i = 0; i < MAX_POINTS; i++) {
            if(touching[i])
                canvas.drawCircle(x[i], y[i], SIZE, mPaint);
        }
    }
}

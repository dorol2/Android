package com.example.dorol.notepad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class MyImageView extends View {

    private Drawable image;
    private ScaleGestureDetector gestureDetector;
    private float scale = 1.0f;

    public MyImageView(Context context) {
        super(context);
        image = context.getDrawable(R.drawable.flower); // 이미지 가져오기
        setFocusable(true);
        // 해당 개체의 좌표값 지정 //실제 크기를 가져와서 지정(단, getIntrinsicWidth는 drawable에 있는 이미지의 경우 Density가 적용되어 디바이스의 density값에 영향을 받는다. )
        image.setBounds(0,0, image.getIntrinsicWidth(), image.getIntrinsicHeight());

        //특정 뷰가 여러 가지 제스처 이벤트를 처리해야 할 때 사용
        gestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scale *= detector.getScaleFactor();

                if(scale < 0.1f)
                    scale = 0.1f;

                if(scale > 10.0f)
                    scale = 10.0f;

                invalidate();
                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.scale(scale, scale);
        image.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        invalidate();
        return true;
    }
}

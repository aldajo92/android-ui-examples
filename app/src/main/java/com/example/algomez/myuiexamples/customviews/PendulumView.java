package com.example.algomez.myuiexamples.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by algomez on 1/6/17.
 */

public class PendulumView extends View {

  private static final String TAG = PendulumView.class.getSimpleName();

  private Paint paint = new Paint();
  private Path path = new Path();

  private int parentWidth = 0;
  private int parentHeight = 0;

  private float originX = 0, originY = 0;
  private float pendulumL = 0;
  private float pendulumX = 0, pendulumY = 0;
  private float massRadius = 0;
  private float degrees = 0;

  private final float stroke = 6f;

  public PendulumView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initComponents();
  }

  private void initComponents() {
    paint.setAntiAlias(true);
    paint.setStrokeWidth(stroke);
    paint.setColor(Color.BLACK);
    paint.setStyle(Paint.Style.FILL_AND_STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
  }

  @Override protected void onDraw(Canvas canvas) {
    paint.setColor(Color.RED);
    path.moveTo(originX, originY);
    path.lineTo(pendulumX, pendulumY);
    path.addCircle(pendulumX, pendulumY, massRadius, Path.Direction.CCW);
    paint.setColor(Color.BLUE);
    canvas.drawPath(path, paint);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    float eventX = event.getX();
    float eventY = event.getY();

    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        return true;
      case MotionEvent.ACTION_MOVE:
        float degree = (float) Math.atan((originX - eventX) / (originY - eventY));
        Log.i(TAG, "onTouchEvent: " + degree);
        updateMeasures(degree);
        break;
      case MotionEvent.ACTION_UP:
        Log.i(TAG, "onTouchEvent: UP");
        break;
      default:
        return false;
    }

    invalidate();
    return true;
  }

  @Override public void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    parentWidth = w;
    parentHeight = h;
    updateMeasures(degrees);
  }

  public void setDegrees(float degrees) {
    this.degrees = degrees;
  }

  public void updateMeasures(float degrees) {
    pendulumL = 0.5f * parentHeight;
    massRadius = 0.1f * pendulumL;
    originX = parentWidth / 2f;
    originY = 0;
    pendulumX = (parentWidth / 2f) + (pendulumL * (float) Math.sin(degrees));
    pendulumY = pendulumL * (float) Math.cos(degrees);

    path.reset();
    setDegrees(degrees);
    invalidate();
  }
}

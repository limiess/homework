package com.example.homework1.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.example.homework1.R;


public class CircularView extends View {
    private String textContent;
    private int textSize;
    private int textColor;
    private int circleColor;
    private int defaultWidth;
    private  int defaultHeight;
    private Paint paintText;
    private Paint paintCircle;
    /*public CircularView(Context context) {
        this(context,null);
    }*/

    public CircularView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircularView,
                0, 0);
        try {
             textContent = a.getString(R.styleable.CircularView_textContent);
             textSize = a.getDimensionPixelSize(R.styleable.CircularView_textSize, 20);
             textColor = a.getColor(R.styleable.CircularView_textColor, 0);
             circleColor=a.getColor(R.styleable.CircularView_circleColor, 0);
             defaultWidth=a.getInteger(R.styleable.CircularView_defaultWidth, 400);
             defaultHeight=a.getInteger(R.styleable.CircularView_defaultHeight, 400);
             paintText=new Paint();
             paintCircle=new Paint();
             paintText.setAntiAlias(true);
             paintText.setTextSize(textSize);
             paintText.setColor(textColor);
             paintText.setStyle(Paint.Style.FILL);
             paintCircle.setAntiAlias(true);
             paintCircle.setColor(circleColor);
             paintCircle.setStyle(Paint.Style.STROKE);
             paintCircle.setStrokeWidth(3);
        } finally {
            a.recycle();
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = 0;
        int height = 0;
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        if (modeWidth == MeasureSpec.EXACTLY) {
            width = sizeWidth;
        } else if (modeWidth == MeasureSpec.AT_MOST) {
            width = Math.min(defaultWidth, sizeWidth);
        } else {
            width = defaultWidth;
        }

        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        if (modeHeight == MeasureSpec.EXACTLY) {
            height = sizeHeight;
        } else if (modeHeight == MeasureSpec.AT_MOST) {
            height =  Math.min(defaultHeight, sizeHeight);
        } else {
            height =  defaultHeight;
        }
        setMeasuredDimension(width, height);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(textContent, 150,  210, paintText);
        canvas.drawCircle(200, 200,Math.min(defaultHeight,defaultWidth)/2, paintCircle);
        canvas.drawCircle(200, 200,Math.min(defaultHeight,defaultWidth)/4, paintCircle);
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }

    public void setDefaultHeight(int defaultHeight) {
        this.defaultHeight = defaultHeight;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public void setDefaultWidth(int defaultWidth) {
        this.defaultWidth = defaultWidth;
    }

    public int getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
        invalidate();
        requestLayout();
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        invalidate();
        requestLayout();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        invalidate();
        requestLayout();
    }
}

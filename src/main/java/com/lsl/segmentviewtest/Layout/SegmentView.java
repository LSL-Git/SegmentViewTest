package com.lsl.segmentviewtest.Layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.renderscript.Type;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lsl.segmentviewtest.R;

/**
 * Created by lenovo on 2016/10/13.
 */

public class SegmentView extends LinearLayout {

    private TextView leftTextView;
    private TextView rightTextView;
    private onSegmentViewClickListener segmentlistener;

    public SegmentView(Context context) {
        super(context);
        initView();
    }

    public SegmentView(Context context, AttributeSet attrs) {
        super(context,attrs);
        initView();
    }

    private void initView() {
        leftTextView = new TextView(getContext());
        rightTextView = new TextView(getContext());

        //
        leftTextView.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        rightTextView.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));

        //
        leftTextView.setText("消息");
        rightTextView.setText("电话");

        //
        ColorStateList csl = getResources().getColorStateList(R.color.segment_text_color_selector);
        leftTextView.setTextColor(csl);
        rightTextView.setTextColor(csl);

        //
        leftTextView.setGravity(Gravity.CENTER);
        rightTextView.setGravity(Gravity.CENTER);

        //
        leftTextView.setPadding(5, 6, 5, 6);
        rightTextView.setPadding(5, 6, 5, 6);

        //
        setSegmentTextSize(18);

        //
        leftTextView.setBackgroundResource(R.drawable.segment_left_background);
        rightTextView.setBackgroundResource(R.drawable.segment_right_background);

        //
        leftTextView.setSelected(true);

        //
        this.removeAllViews();
        this.addView(leftTextView);
        this.addView(rightTextView);
        this.invalidate();

        leftTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftTextView.isSelected()) {
                    return;
                }
                leftTextView.setSelected(true);
                rightTextView.setSelected(false);
                if (segmentlistener != null) {
                    segmentlistener.onSegmentViewClick(leftTextView, 0);
                }
            }
        });

        rightTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightTextView.isSelected()) {
                    return;
                }
                leftTextView.setSelected(false);
                rightTextView.setSelected(true);
                if (segmentlistener != null) {
                    segmentlistener.onSegmentViewClick(rightTextView, 1);
                }
            }
        });

    }

    private void setSegmentTextSize(int sp) {
        leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
        rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
    }

    public void setSelect(int pos) {
        if (pos == 0) {
            leftTextView.setSelected(true);
            rightTextView.setSelected(false);
        }
        if (pos == 1) {
            leftTextView.setSelected(false);
            rightTextView.setSelected(true);
        }
    }

    public void setSegmentText(CharSequence text, int postion) {
        if (postion == 0) {
            leftTextView.setText(text);
        }
        if (postion == 1) {
            rightTextView.setText(text);
        }
    }

    public interface onSegmentViewClickListener {
        public void onSegmentViewClick(View view, int postion);
    }

    public void setOnSegmentViewClickListener(onSegmentViewClickListener segmentlistener) {
        this.segmentlistener = segmentlistener;
    }
}

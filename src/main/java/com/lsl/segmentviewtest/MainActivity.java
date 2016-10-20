package com.lsl.segmentviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lsl.segmentviewtest.Layout.SegmentView;

public class MainActivity extends AppCompatActivity {

    private SegmentView segmentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        segmentView = (SegmentView) findViewById(R.id.segmentview);
        segmentView.setOnSegmentViewClickListener(new SegmentView.onSegmentViewClickListener() {
            @Override
            public void onSegmentViewClick(View view, int postion) {
                switch (postion) {
                    case 0:
                        Toast.makeText(MainActivity.this, "你点击了消息", 0).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "你点击了电话", 0).show();
                        break;
                }
            }
        });
    }
}

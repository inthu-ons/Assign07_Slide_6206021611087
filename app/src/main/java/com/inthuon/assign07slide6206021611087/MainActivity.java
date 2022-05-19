package com.inthuon.assign07slide6206021611087;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private Button stopBtn;
    int res_image[] = {R.drawable.p1, R.drawable.p2,
            R.drawable.p3, R.drawable.p4 ,R.drawable.p5, R.drawable.p6,
            R.drawable.p7, R.drawable.p8};
    Button startSlide;
    private Handler mHandler = new Handler( Looper.myLooper());
    int iSlide = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(res_image[iSlide]);
        startSlide = (Button) findViewById( R.id.startBtn);
        startSlide.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                imageView .setImageResource(res_image[iSlide]);
                mHandler.postDelayed( mUpdateTimeTask , 2000);
            }
        });
        stopBtn = (Button) findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.removeCallbacks(mUpdateTimeTask);
            }
        });
    }
    private Runnable mUpdateTimeTask = new Runnable () {
        public void run() {
            if (iSlide < 7) {
                iSlide ++;
                imageView .setImageResource(res_image[iSlide]);
                mHandler.postDelayed(this, 2000);
            }
            else {
                iSlide = 0;
            }
        }
    };
}
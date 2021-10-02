package com.example.lbooks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    ImageView SplashImage;
    LottieAnimationView lottieAnimationView;
    ViewPager nslideViewPager;
    LinearLayout nDotLayout;
    Button nxtBtn,bckBtn,skipBtn;

    TextView[] dots;
    ViewPageAdpater viewPageAdpater;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SplashImage=findViewById(R.id.img);
        lottieAnimationView=findViewById(R.id.lottie);
        SplashImage.animate().translationY(-2800).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);


        nxtBtn = findViewById(R.id.nxtBtn);
        bckBtn = findViewById(R.id.bckBtn);
        skipBtn = findViewById(R.id.skipButton);

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getItem(0)<2)
                {
                    nslideViewPager.setCurrentItem(getItem(1),true);
                }
                else{
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getItem(0)>0)
                {
                    nslideViewPager.setCurrentItem(getItem(-1),true);
                }

            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        nslideViewPager = findViewById(R.id.slideViewPager);
        nDotLayout = findViewById(R.id.indicator_layout);
        viewPageAdpater = new ViewPageAdpater(this);
        nslideViewPager.setAdapter(viewPageAdpater);
        setUpindicator(0);
        nslideViewPager.addOnPageChangeListener(viewListner);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setUpindicator(int position)
    {
        dots=new TextView[3];
        nDotLayout.removeAllViews();

        for(int i=0; i < dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.teal_200,getApplicationContext().getTheme()));

        }
        dots[position].setTextColor(getResources().getColor(R.color.purple_200,getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onPageSelected(int position) {
            setUpindicator(position);
            if(position>0){
                bckBtn.setVisibility(View.VISIBLE);
            }else{
                bckBtn.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i)
    {
        return nslideViewPager.getCurrentItem()+i;
    }

}
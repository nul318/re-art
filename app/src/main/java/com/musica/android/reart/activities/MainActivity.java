package com.musica.android.reart.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.ParallaxAdapter;

import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer;

public class MainActivity extends SuperActivity {

    //    Views Naming Rule
    ViewPager mPager;
    FragmentStatePagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.first_test:
//                firstTest();
//                break;
//            case R.id.second_test:
//                secondTest(1);
//                break;
//            case R.id.third_test:
//                thirdTest(Utils.getNowByTimeStamp());
//                break;
//        }
    }

    @Override
    void initViews() {
        mPager = findViewById(R.id.main_vp_list);
        mPager.setPageTransformer(false, new ParallaxPagerTransformer(R.id.image));

        mAdapter = new ParallaxAdapter(getSupportFragmentManager());
        ((ParallaxAdapter) mAdapter).setPager(mPager); //only for this transformer
//        mPager.setPageTransformer(false, pt);
        ((ParallaxAdapter) mAdapter).add(new ParallaxFragment(R.drawable.main1));
        ((ParallaxAdapter) mAdapter).add(new ParallaxFragment(R.drawable.main2));
        ((ParallaxAdapter) mAdapter).add(new ParallaxFragment(R.drawable.main3));
        ((ParallaxAdapter) mAdapter).add(new ParallaxFragment(R.drawable.main4));
        //       뷰페이저 미리보기 설정//
        mPager.setClipToPadding(false);
        int dpValue = 20;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        mPager.setPadding(margin, 0, margin, 0);
        mPager.setPageMargin(margin/2);
        mPager.setAdapter(mAdapter);
    }


}

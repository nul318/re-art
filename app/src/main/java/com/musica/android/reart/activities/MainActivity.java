package com.musica.android.reart.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.ParallaxAdapter;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer;

public class MainActivity extends SuperActivity implements FloatingActionMenu.MenuStateChangeListener, View.OnLayoutChangeListener{

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
        ((ParallaxAdapter) mAdapter).add(new ParallaxFragment(R.drawable.group_7));
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

        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getDrawable(R.drawable.ic_hone));

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .setPosition(4)
//                .setBackgroundDrawable(R.drawable.oval_2)
//                .setLayoutParams(new FloatingActionButton.LayoutParams(30,30))

                .build();
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
// repeat many times:
//        ImageView itemIcon = new ImageView(this);
//        itemIcon.setImageDrawable(getDrawable(R.drawable.ic_person));
//        SubActionButton button1 = itemBuilder.setContentView(itemIcon).build();
//        ImageView itemIcon2 = new ImageView(this);
//        itemIcon2.setImageDrawable(getDrawable(R.drawable.ic_crown));
//        SubActionButton button2 = itemBuilder.setContentView(itemIcon).build();
//        ImageView itemIcon3 = new ImageView(this);
//        itemIcon3.setImageDrawable(getDrawable(R.drawable.ic_timeline));
//        SubActionButton button3 = itemBuilder.setContentView(itemIcon).build();

        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);

        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_person));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_crown));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_timeline));


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(itemBuilder.setContentView(rlIcon1).build())
                .addSubActionView(itemBuilder.setContentView(rlIcon2).build())
                .addSubActionView(itemBuilder.setContentView(rlIcon3).build())
                .attachTo(actionButton)
                .build();

        actionMenu.getSubActionItems().get(0).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        actionMenu.getSubActionItems().get(1).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        actionMenu.getSubActionItems().get(2).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

    }

    @Override
    public void onMenuOpened(FloatingActionMenu floatingActionMenu) {
            
    }

    @Override
    public void onMenuClosed(FloatingActionMenu floatingActionMenu) {

    }
}

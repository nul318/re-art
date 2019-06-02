package com.musica.android.reart.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.WriteImageAdapter;

import java.util.ArrayList;

public class FirstWritingActivity extends SuperActivity {

    private ViewPager mViewPagerImage;
    private WriteImageAdapter mWriteImageAdapter;
    private Context mContext;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_writing);

        Button btnNext = findViewById(R.id.first_writing_btn);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstWritingActivity.this, SecondWritingActivity.class);
                startActivity(intent);
            }
        });

        mViewPagerImage=findViewById(R.id.first_vp);

        WriteImageFragment imageFragment = new WriteImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("imageId", R.drawable.empty_review);
        imageFragment.setArguments(bundle);
        fragments.add(imageFragment);

        WriteImageFragment imageFragment2 = new WriteImageFragment();
        Bundle bundle2 = new Bundle();
        bundle.putInt("imageId", R.drawable.empty_review);
        imageFragment.setArguments(bundle2);
        fragments.add(imageFragment2);

        WriteImageFragment imageFragment3 = new WriteImageFragment();
        Bundle bundle3 = new Bundle();
        bundle.putInt("imageId", R.drawable.empty_review);
        imageFragment.setArguments(bundle3);
        fragments.add(imageFragment3);

        mViewPagerImage.setClipToPadding(false);
        int dpValue = 30;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        mViewPagerImage.setPadding(margin, 0, margin, 0);
        mViewPagerImage.setPageMargin(margin/2);

        mWriteImageAdapter = new WriteImageAdapter(getSupportFragmentManager(), fragments);

        mViewPagerImage.setAdapter(mWriteImageAdapter);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    void initViews() {

    }
}
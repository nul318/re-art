package com.musica.android.reart.activities;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.ParallaxAdapter;

@SuppressLint("ValidFragment")
public class ParallaxFragment extends Fragment {

    private ParallaxAdapter mAdapter;
    int mImageId;
    @SuppressLint("ValidFragment")
    public ParallaxFragment(int resource) {
        mImageId=resource;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_parallax, container, false);
        final ImageView image = v.findViewById(R.id.image);

        image.setImageResource(mImageId);
//        image.post(new Runnable() {
//            @Override
//            public void run() {
//                Matrix matrix = new Matrix();
//                matrix.reset();
//
//                float wv = image.getWidth();
//                float hv = image.getHeight();
//
//                float wi = image.getDrawable().getIntrinsicWidth();
//                float hi = image.getDrawable().getIntrinsicHeight();
//
//                float width = wv;
//                float height = hv;
//
//                if (wi / wv > hi / hv) {
//                    matrix.setScale(hv / hi, hv / hi);
//                    width = wi * hv / hi;
//                } else {
//                    matrix.setScale(wv / wi, wv / wi);
//                    height= hi * wv / wi;
//                }
//
//                matrix.preTranslate((wv - width) / 2, (hv - height) / 2);
//                image.setScaleType(ImageView.ScaleType.MATRIX);
//                image.setImageMatrix(matrix);
//            }
//        });
//
//        ImageView logo = (ImageView) v.findViewById(R.id.tutorial_logo);
//        logo.setImageResource(getArguments().getInt("imageLogo"));
//
//        ImageView imageText = (ImageView) v.findViewById(R.id.tutorial_text);
//        imageText.setImageResource(getArguments().getInt("imageText"));

        return v;
    }

    public void setAdapter(ParallaxAdapter adapter) {
        mAdapter = adapter;
    }
}

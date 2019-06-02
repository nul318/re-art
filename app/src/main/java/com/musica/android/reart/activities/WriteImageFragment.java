package com.musica.android.reart.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.ParallaxAdapter;


public class WriteImageFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write, container, false);

//        ImageView imageView = view.findViewById(R.id.image);
//        if (getArguments() != null) {
//            Bundle args = getArguments();
//            imageView.setImageResource(args.getInt("imageId"));
//        }
        return view;
    }

    public WriteImageFragment() {}

}
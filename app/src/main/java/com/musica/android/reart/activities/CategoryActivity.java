package com.musica.android.reart.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.CategoryListAdapter;
import com.musica.android.reart.entities.Category;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView mRecyclerViewKeyword;
    CategoryListAdapter mKeywordListAdapter;
    Context mContext;
    ArrayList<Category> mArrayListKeyword=new ArrayList<>();
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        init();
    }

    void init(){
        mArrayListKeyword.add(new Category(R.id.))
        mRecyclerViewKeyword = findViewById(R.id.category_rv);
        mLayoutManager  = new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false);
        mKeywordListAdapter = new CategoryListAdapter(mArrayListKeyword, mContext);
        mRecyclerViewKeyword.setLayoutManager(mLayoutManager);
        mRecyclerViewKeyword.setAdapter(mKeywordListAdapter);
    }

}

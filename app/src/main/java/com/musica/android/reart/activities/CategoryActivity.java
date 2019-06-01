package com.musica.android.reart.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.musica.android.reart.R;
import com.musica.android.reart.adapater.CategoryListAdapter;
import com.musica.android.reart.entities.Category;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView mRecyclerViewKeyword;
    RecyclerView mRecyclerViewCard;
    CategoryListAdapter mKeywordListAdapter;
    CategoryListAdapter mCardListAdapter;
    Context mContext;
    ArrayList<Category> mArrayListKeyword=new ArrayList<>();
    ArrayList<Category> mArrayListCard=new ArrayList<>();
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        init();
    }

    void init(){
        mArrayListKeyword.add(new Category(R.drawable.ic_1));
        mArrayListKeyword.add(new Category(R.drawable.ic_2));
        mArrayListKeyword.add(new Category(R.drawable.ic_2));
        mArrayListKeyword.add(new Category(R.drawable.ic_2));
        mRecyclerViewKeyword = findViewById(R.id.category_rv);
        mLayoutManager  = new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false);
        mKeywordListAdapter = new CategoryListAdapter(mArrayListKeyword, mContext);
        mRecyclerViewKeyword.setLayoutManager(mLayoutManager);
        mRecyclerViewKeyword.setAdapter(mKeywordListAdapter);

        mRecyclerViewCard=findViewById(R.id.category_rv2);
        mArrayListCard.add(new Category(R.drawable.card1));
        mArrayListCard.add(new Category(R.drawable.card2));
        mArrayListCard.add(new Category(R.drawable.card1));
        mArrayListCard.add(new Category(R.drawable.card2));
        mLayoutManager  = new LinearLayoutManager(mContext, LinearLayout.HORIZONTAL, false);
        mCardListAdapter = new CategoryListAdapter(mArrayListCard, mContext);
        mRecyclerViewCard.setLayoutManager(mLayoutManager);
        mRecyclerViewCard.setAdapter(mCardListAdapter);

        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getDrawable(R.drawable.ic_timeline_2));

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .setPosition(4)
//                .setBackgroundDrawable(R.drawable.oval_2)
//                .setLayoutParams(new FloatingActionButton.LayoutParams(30,30))

                .build();
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);

        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_write_wh_24));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_crown));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_hone));


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(itemBuilder.setContentView(rlIcon1).build())
                .addSubActionView(itemBuilder.setContentView(rlIcon2).build())
                .addSubActionView(itemBuilder.setContentView(rlIcon3).build())
                .attachTo(actionButton)
                .build();


    }

}

package com.musica.android.reart.adapater;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.musica.android.reart.R;
import com.musica.android.reart.entities.Category;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private ArrayList<Category> kewordList;
    public static Context context;


    public CategoryListAdapter(ArrayList<Category> items, Context context) {
        this.kewordList = items;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_category, viewGroup, false);
        //txtName.setText(items.get(position));
        return new ViewHolder(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final Category item = kewordList.get(position);
        viewHolder.mImageView.setImageResource(item.getId());
//        viewHolder.txtKeyword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(context, SearchResultActivity.class);
////                intent.putExtra("keyword",item.getKeyword());
////                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return kewordList.size();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        //mViewPagerState.put(holder.getAdapterPosition(), holder.vp.getCurrentItem());
        super.onViewRecycled(holder);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mImageView=itemView.findViewById(R.id.imageView3);


        }
    }

}
package com.example.yeyi.startnewtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

public class SizhAdapter extends RecyclerView.Adapter<SizhAdapter.ViewHolder> {
    private Context mContext;
    private List<Sizh> mSizhList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView sizhImage;
        TextView sizhName;
        TextView sizhText;

        public ViewHolder(@NonNull View view) {
            super(view);
            cardView = (CardView) view;
            sizhText = (TextView) view.findViewById(R.id.sizh_text);
            sizhImage = (ImageView) view.findViewById(R.id.sizh_image);
            sizhName = (TextView) view.findViewById(R.id.sizh_name);
        }
    }
    public SizhAdapter(List<Sizh> sizhList){
        mSizhList = sizhList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.sizh_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Sizh sizh = mSizhList.get(position);
                Intent intent = new Intent(mContext,InInterface.class);
//                intent.putExtra(SizhActivity.SIZH_NAME,sizh.getName());
//                intent.putExtra(SizhActivity.SIZH_IMAGE_ID,sizh.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sizh sizh = mSizhList.get(position);
        holder.sizhName.setText(sizh.getName());
        Glide.with(mContext).load(sizh.getImageId()).into(holder.sizhImage);
    }

    @Override
    public int getItemCount() {
        return mSizhList.size();
    }


}

package com.swg.mpandroidchartdemo.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swg.mpandroidchartdemo.R;
import com.swg.mpandroidchartdemo.bean.ContentItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by swg on 2017/11/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ContentItem> mData;
    private Typeface mTypeFaceLight;
    private Typeface mTypeFaceRegular;

    public MyAdapter(Context context, List<ContentItem> data) {
        mTypeFaceLight = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
        mTypeFaceRegular = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
        mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ContentItem item = mData.get(position);
        holder.tvNew.setTypeface(mTypeFaceRegular);
        holder.tvName.setTypeface(mTypeFaceLight);
        holder.tvDesc.setTypeface(mTypeFaceLight);
        holder.tvName.setText(item.name);
        holder.tvDesc.setText(item.desc);
        holder.tvNew.setVisibility(item.isNew ? View.VISIBLE : View.GONE);
        if (mListener != null) {
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvDesc)
        TextView tvDesc;
        @BindView(R.id.tvNew)
        TextView tvNew;
        View rootView;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}

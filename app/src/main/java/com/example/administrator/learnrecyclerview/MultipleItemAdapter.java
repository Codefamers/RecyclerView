package com.example.administrator.learnrecyclerview;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/22 0022.
 */
public class MultipleItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG ="MultipleItemAdapter" ;

    //JavaEnum 简单的用法一般用于代表一组常用常量，可用来代表一类相同类型的常量值
    public enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,//表示图片类型
        ITEM_TYPE_TEXT//表示文本类型
    }

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private String[] mTitles;

    public MultipleItemAdapter(Context context) {
        mTitles = context.getResources().getStringArray(R.array.titles);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG,"viewType"+viewType);
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new ImageViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_image, parent, false));
        } else {
            return new TextViewHolder(LayoutInflater.from(mContext).
                    inflate(R.layout.item_text, parent, false));
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TextViewHolder){
                ((TextViewHolder) holder).textView.setText(mTitles[position]);
            }else if(holder instanceof ImageViewHolder){
                ((ImageViewHolder) holder).textView.setText(mTitles[position]);
            }

    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }
    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView=(TextView) itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
    public static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}
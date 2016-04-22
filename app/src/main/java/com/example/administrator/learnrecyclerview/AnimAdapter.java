package com.example.administrator.learnrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2016/4/22 0022.
 */
public class AnimAdapter extends RecyclerView.Adapter<AnimAdapter.NormalTextViewHolder>{
    private  LayoutInflater mLayoutInflater;
    private  Context mContext;
    private ArrayList<String>mTitles=new ArrayList<>();

    public AnimAdapter(Context context){
        mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
        for (int i = 0; i <10; i++) {
            mTitles.add("屈淮南啊哈哈哈哈");
        }
    }
    public  void addTitles(String[] titles){
        Collections.addAll(mTitles, titles);
        notifyItemChanged(0,titles.length);//当增加多条条目时调用该方法
    }
    public void addTitle(String title){
        mTitles.add(1,title);
        notifyItemInserted(1);//
    }
    public void remove(int position){
        mTitles.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public AnimAdapter.NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_text,
                parent,false),this);
    }

    @Override
    public void onBindViewHolder(AnimAdapter.NormalTextViewHolder holder, int position) {
        holder.textView.setText(mTitles.get(position));


    }

    @Override
    public int getItemCount() {
        return mTitles==null?0:mTitles.size();
    }
    public static class NormalTextViewHolder extends  RecyclerView.ViewHolder{
        private TextView textView;
        private AnimAdapter mAdapter;
        public NormalTextViewHolder(View itemView,AnimAdapter adapter) {
            super(itemView);
            mAdapter=adapter;
            textView= (TextView) itemView.findViewById(R.id.text_view);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getAdapterPosition());
                    if (getAdapterPosition()==2){
                        mAdapter.remove(getAdapterPosition());
                    }else {
                        mAdapter.addTitle("quhuainan"+getAdapterPosition());
                    }
                }
            });
        }

    }
}

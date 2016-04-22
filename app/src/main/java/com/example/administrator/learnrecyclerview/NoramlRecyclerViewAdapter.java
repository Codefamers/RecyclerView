package com.example.administrator.learnrecyclerview;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/21 0021.
 */
public class NoramlRecyclerViewAdapter extends RecyclerView.Adapter<NoramlRecyclerViewAdapter.NormalTextViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private String[] mTitles;
    private NormalTextViewHolder normalTextViewHolder;

    public NoramlRecyclerViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mTitles = context.getResources().getStringArray(R.array.titles);
    }

    //获取视图
    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInfalter.infalte与View.infalte的区别？
        return normalTextViewHolder = new NormalTextViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_text, parent,
                false));
    }

    //给视图绑定数据
    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        normalTextViewHolder = holder;
        holder.mTextView.setText(mTitles[position]);
        Log.d("NormalTextViewHolder", mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private CardView cardView;

        //private LinearLayout line3;
        public NormalTextViewHolder(View itemView) {
            super(itemView);
            //注意 View.inflate获得的对象是Layout对象
            cardView = (CardView) itemView;
            mTextView = (TextView) cardView.findViewById(R.id.text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getAdapterPosition());
                }
            });
        }

    }
}

package com.example.administrator.learnrecyclerview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity ";
    private RecyclerView mRecyclerView;
    private AnimAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new AnimAdapter(this);
        //让recyclerView中的控件以线性布局方式显现
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局方式
        //让recyclerView中的控件以Grid布局显示
        // mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        // mRecyclerView.setItemAnimator();//设置Item增加和移除动画
        // mRecyclerView.addItemDecoration();//添加分割线
        // mRecyclerView.setAdapter(new NoramlRecyclerViewAdapter(this));//正常适配器
        // mRecyclerView.setAdapter(new MultipleItemAdapter(this));//不定项目适配器
        mRecyclerView.setAdapter(adapter);//动画适配器

    }

    public void addItem(View v) {
        adapter.addTitle("屈淮南");
        Log.d(TAG, "哈哈");
    }

    public void removeItem(View v) {
        adapter.remove(2);
        Log.d(TAG, "哈哈");
    }
}

package com.kyletung.androiddailyrecord.main;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kyletung.androiddailyrecord.R;
import com.kyletung.androiddailyrecord.base.ui.BaseActivity;
import com.kyletung.androiddailyrecord.main.adapter.MainAdapter;
import com.kyletung.androiddailyrecord.main.model.MainModel;
import com.kyletung.androiddailyrecord.module.view.ViewsActivity;
import com.kyletung.androiddailyrecord.module.viewgroup.rectlayout.RectLayoutActivity;

import java.util.ArrayList;

/**
 * All rights reserved by Author<br>
 * Author: Dong YuHui<br>
 * Email: <a href="mailto:dyh920827@gmail.com">dyh920827@gmail.com</a><br>
 * Blog: <a href="http://www.kyletung.com">www.kyletung.com</a><br>
 * Create Time: 2016/03/07 at 20:07<br>
 * 应用入口，各个控件与效果的页面都由此进入
 */
public class MainActivity extends BaseActivity implements MainAdapter.OnItemClickListener {

    private static final String[] items = {"RectLayout", "Views(常见)"};

    @Override
    protected int getContentLayout() {
        return R.layout.main_activity;
    }

    @Override
    protected void initView() {
        initToolbar("Main", false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        MainAdapter adapter = new MainAdapter(this, R.layout.main_recycler_item);
        adapter.setOnItemClickListener(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        // init adapter
        ArrayList<MainModel> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            list.add(new MainModel(i, items[i]));
        }
        adapter.addList(list);
    }

    @Override
    public void onItemClick(int position, String name) {
        switch (position) {
            case 0:
                Intent intentRectLayout = new Intent(this, RectLayoutActivity.class);
                startActivity(intentRectLayout);
                break;
            case 1:
                Intent intentViews = new Intent(this, ViewsActivity.class);
                startActivity(intentViews);
        }
    }

}
package com.textbook.browse.ui.fragments;

import android.Manifest;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.silang.superfileview.R;
import com.textbook.browse.face.OnItemClickListener;
import com.textbook.browse.model.Album;
import com.textbook.browse.model.Format;
import com.textbook.browse.ui.activitys.FileDisplayActivity;
import com.textbook.browse.ui.adapter.BookListAdapter;
import com.textbook.browse.ui.base.BaseFragment;
import com.textbook.browse.util.NameParse;
import com.textbook.browse.util.TLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by v_jishuaipeng on 2020-09-07.
 * 描述: 书籍列表
 */
public class BookListFragment extends BaseFragment {
    private String title;
    private List<Album> list;
    private BookListAdapter bookListAdapter;
    private RecyclerView mRecyclerView;

    public static BookListFragment newInstance(String title, List<Album> list) {
        BookListFragment bookListFragment = new BookListFragment();
        bookListFragment.title = title;
        bookListFragment.list = list;
        return bookListFragment;
    }

    public List<Album> getList() {
        return list;
    }

    public String getTitle() {
        return title;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_booklisk;
    }

    @Override
    protected void initView(View root) {


        mRecyclerView = (RecyclerView) root.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        bookListAdapter = new BookListAdapter();
        bookListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String[] perms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE};
                if (!EasyPermissions.hasPermissions(mContext, perms)) {
                    EasyPermissions.requestPermissions(BookListFragment.this, "需要访问手机存储权限！", 10086, perms);
                } else {
                    FileDisplayActivity.show(mContext,
                            bookListAdapter.getAlbums().get(position).getPath());
                }
            }
        });
        mRecyclerView.setAdapter(bookListAdapter);
        bookListAdapter.setAlbums(list);
    }

}

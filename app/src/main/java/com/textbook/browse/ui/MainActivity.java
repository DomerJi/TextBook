package com.textbook.browse.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.silang.superfileview.R;
import com.textbook.browse.model.Album;
import com.textbook.browse.model.Format;
import com.textbook.browse.model.VType;
import com.textbook.browse.ui.base.BaseActivity;
import com.textbook.browse.ui.fragments.BookListFragment;
import com.textbook.browse.util.NameParse;
import com.textbook.browse.util.TLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    HashMap<Integer, List<Album>> mainDatas = new HashMap<>();
    ArrayList<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();

        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initDatas() {

        ArrayList<Album> albums = new ArrayList<>();
        try {
            String[] files = getAssets().list("");
            TLog.d("files.length = " + files.length);
            TLog.d("files = " + Arrays.toString(files));
            for (String name : files) {

                if (name.startsWith(Format.HEAD) && name.endsWith(Format.PDF)) {
//                    String filePath = AssetsUtil.getFromAssets(getBaseContext(), name);

                    Album bookAlbum = new Album(name);
                    NameParse.parse(name, bookAlbum);

                    TLog.d("initDatas = " + bookAlbum.toString());
                    albums.add(bookAlbum);
                    if (mainDatas.containsKey(bookAlbum.getCourse())) {
                        mainDatas.get(bookAlbum.getCourse()).add(bookAlbum);
                    } else {
                        ArrayList<Album> list = new ArrayList<>();
                        list.add(bookAlbum);
                        mainDatas.put(bookAlbum.getCourse(), list);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ViewPager适配器
    private class MainPagerAdapter extends FragmentPagerAdapter {

        private final List<BookListFragment> result = new ArrayList<>();

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
            for (Integer course : mainDatas.keySet()) {
                BookListFragment fragment = BookListFragment.newInstance(VType.getCourse(course), mainDatas.get(course));
                result.add(fragment);
            }
        }

        @Override
        public Fragment getItem(int position) {
            return result.get(position);
        }

        @Override
        public int getCount() {
            return result.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return result.get(position).getTitle();
        }
    }

}

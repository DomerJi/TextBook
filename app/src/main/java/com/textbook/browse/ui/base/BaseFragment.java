package com.textbook.browse.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by v_jishuaipeng on 2020-09-03.
 * 描述:
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    protected abstract int getContentView();

    protected abstract void initView(View root);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(getContentView(), container, false);
        mContext = getContext();
        initView(contentView);
        return contentView;
    }

}

package com.textbook.browse.util;

import android.widget.Toast;

import com.textbook.browse.App;

/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public class ToastUtil {

    public static void show(CharSequence text) {
        Toast.makeText(App.getAppContext(), text, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence text) {
        Toast.makeText(App.getAppContext(), text, Toast.LENGTH_LONG).show();
    }

}

package com.textbook.browse.util;

import android.text.TextUtils;

import com.textbook.browse.model.Album;
import com.textbook.browse.model.Format;

import java.util.Arrays;

/**
 * Created by v_jishuaipeng on 2020-09-03.
 * 描述:
 */
public class NameParse {

    public static boolean parse(String path, Album album) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }

        if (path.endsWith("." + Format.DOCX)) {
            path = path.replace("." + Format.DOCX, "");
        } else if (path.endsWith("." + Format.PDF)) {
            path = path.replace("." + Format.PDF, "");
        }
        TLog.d("NameParse_path = " + path);

        String[] arrs = path.split("_");
        // book_02_07_03_01.pdf
        // 头 学科 年级 上下册 出版社
        TLog.d("NameParse_arrs = " + Arrays.toString(arrs));
        if (arrs != null && arrs.length == 5) {
            album.setCourse(Integer.parseInt(arrs[1]));
            album.setGrade(Integer.parseInt(arrs[2]));
            album.setVolume(Integer.parseInt(arrs[3]));
            album.setType(Integer.parseInt(arrs[4]));
            return true;
        }


        return false;

    }

}

package com.textbook.browse.model;

import com.textbook.browse.model.book.Book_01_07_03_01;
import com.textbook.browse.model.book.Book_02_07_03_01;
import com.textbook.browse.model.book.Book_02_08_03_01;
import com.textbook.browse.model.book.Book_02_09_03_01;
import com.textbook.browse.util.TLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public class CatalogueFactory {

    private static final String TAG = "CatalogueFactory";

    // 数学 七年级 下册 人教版
    public static final String BOOK_02_07_03_01 = "book_02_07_03_01";
    public static final String BOOK_02_08_03_01 = "book_02_08_03_01";
    public static final String BOOK_02_09_03_01 = "book_02_09_03_01";

    public static final String BOOK_01_07_03_01 = "book_01_07_03_01";

    private static HashMap<String, CatalogueFace> factory;

    static {
        factory = new HashMap<>();
        // 数学
        factory.put(BOOK_02_07_03_01, new Book_02_07_03_01());
        factory.put(BOOK_02_08_03_01, new Book_02_08_03_01());
        factory.put(BOOK_02_09_03_01, new Book_02_09_03_01());

        // 语文
        factory.put(BOOK_01_07_03_01, new Book_01_07_03_01());

    }

    public static List<Catalogue> getCatalogueList(String fileName) {
        TLog.d(TAG, "getCatalogueList() fileName = " + fileName);
        for (String key : factory.keySet()) {
            if (fileName.contains(key)) {
                TLog.d(TAG, "key = " + key);
                return factory.get(key).getCatalogueList();
            }
        }
        return new ArrayList<>();
    }

    public static TreeMap<Integer, Catalogue> getCatalogueMap(String fileName) {
        TLog.d(TAG, "getCatalogueMap() fileName = " + fileName);
        for (String key : factory.keySet()) {
            if (fileName.contains(key)) {
                TLog.d(TAG, "key = " + key);
                return factory.get(key).getCatalogueMap();
            }
        }
        return new TreeMap<>();
    }

    public static String[] getHeads(String fileName) {
        TLog.d(TAG, "getHeads() fileName = " + fileName);
        for (String key : factory.keySet()) {
            if (fileName.contains(key)) {
                TLog.d(TAG, "key = " + key);
                return factory.get(key).getHeads();
            }
        }
        return new String[]{};
    }

}

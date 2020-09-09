package com.textbook.browse.util;

import com.textbook.browse.model.BookPage;
import com.textbook.browse.model.CatalogueFace;

import java.util.TreeMap;

/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public class PageUtil {

    private TreeMap<Integer, BookPage> datas = new TreeMap<>();
    private int headCount = 0;

    public PageUtil(int pageCount, String... heads) {

        for (int i = 0; i < pageCount; i++) {
            BookPage catalogue = new BookPage();
            if (heads != null && i < heads.length) {
                headCount = heads.length;
                catalogue.type = CatalogueFace.TYPE_HEAD;
                catalogue.page = (i + 1);
                catalogue.index = i;
                catalogue.name = heads[i];
            } else {
                catalogue.type = CatalogueFace.TYPE_BODY;
                catalogue.page = (i + 1);
                catalogue.index = i;
                catalogue.name = String.valueOf((i + 1 - headCount));
            }
            datas.put(i, catalogue);
        }
    }

    public TreeMap<Integer, BookPage> getDatas() {
        return datas;
    }

    public int getHeadCount() {
        return headCount;
    }
}

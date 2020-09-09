package com.textbook.browse.model;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public interface CatalogueFace {

    // 头
    int TYPE_HEAD = 0;
    // 身体
    int TYPE_BODY = 1;
    // 脚
    int TYPE_FOOT = 2;

    // 章
    int TYPE_CATALOGUE = 0;
    // 节
    int TYPE_NODE = 1;
    // 小节
    int TYPE_SMALLNODE = 2;
    // 小小节
    int TYPE_SMALLNODE2 = 3;


    List<Catalogue> getCatalogueList();

    TreeMap<Integer, Catalogue> getCatalogueMap();

    String[] getHeads();

}

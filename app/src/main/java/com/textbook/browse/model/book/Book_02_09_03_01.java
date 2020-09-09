package com.textbook.browse.model.book;

import com.textbook.browse.model.Catalogue;
import com.textbook.browse.model.CatalogueFace;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by v_jishuaipeng on 2020-09-06.
 * 描述: 数学 九年级 下册 人教版 【目录】
 */
public class Book_02_09_03_01 implements CatalogueFace {

    private String[] heads = new String[]{"封面", "封面", "导引", "目录", "目录", "目录"};
    private ArrayList<Catalogue> arrayList;
    private TreeMap<Integer, Catalogue> mapDatas;

    @Override
    public List<Catalogue> getCatalogueList() {
        if (arrayList != null) {
            return arrayList;
        }
        arrayList = new ArrayList<>();

        Catalogue catalogue = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 1)
                .setChapterName("第二十六章").setChapterDesc("反比例函数")
                .setChapter(26);
        arrayList.add(catalogue);

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 2)
                .setChapterName("26.1").setChapterDesc("反比例函数")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 10)
                        .setChapterDesc("信息技术应用  探索反比例函数的性质")
                        .setChapter(1)));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 12)
                .setChapterName("26.2").setChapterDesc("实际问题与反比例函数")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 17)
                        .setChapterDesc("阅读与思考  生活中的反比例关系")
                        .setChapter(1)));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 19)
                .setChapterName("数学活动")
                .setChapter(3));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 20)
                .setChapterName("小结")
                .setChapter(4));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 21)
                .setChapterName("复习题26")
                .setChapter(5));

        /**
         * =============================================
         * ====================第二十七章====================
         * =============================================
         */

        Catalogue catalogue6 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 23)
                .setChapterName("第二十七章").setChapterDesc("相似")
                .setChapter(27);
        arrayList.add(catalogue6);

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 24)
                .setChapterName("27.1").setChapterDesc("图形的相似")
                .setChapter(1));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 29)
                .setChapterName("27.2").setChapterDesc("相似三角形")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 45)
                        .setChapterDesc("观察与猜想  奇妙的分形图形")
                        .setChapter(1)));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 47)
                .setChapterName("27.3").setChapterDesc("位似")
                .setChapter(3)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 53)
                        .setChapterDesc("信息技术应用  探索位似的性质")
                        .setChapter(1)));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 54)
                .setChapterName("数学活动")
                .setChapter(4));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 56)
                .setChapterName("小结")
                .setChapter(5));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 57)
                .setChapterName("复习题27")
                .setChapter(6));
        /**
         * =============================================
         * ====================第二十八章====================
         * =============================================
         */

        Catalogue catalogue7 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 60)
                .setChapterName("第二十八章").setChapterDesc("锐角三角函数")
                .setChapter(28);
        arrayList.add(catalogue7);

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 61)
                .setChapterName("28.1").setChapterDesc("锐角三角函数")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 70)
                        .setChapterDesc("阅读与思考  一张古老的\"三角函数表\"")
                        .setChapter(1)));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 72)
                .setChapterName("28.2").setChapterDesc("解直角三角形及其应用")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 80)
                        .setChapterDesc("阅读与思考  山坡的高度")
                        .setChapter(1)));

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 81)
                .setChapterName("数学活动")
                .setChapter(3));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 83)
                .setChapterName("小结")
                .setChapter(4));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 84)
                .setChapterName("复习题28")
                .setChapter(5));

        /**
         * =============================================
         * ====================第二十九章====================
         * =============================================
         */

        Catalogue catalogue8 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 86)
                .setChapterName("第二十九章").setChapterDesc("投影与视图")
                .setChapter(29);
        arrayList.add(catalogue8);

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 87)
                .setChapterName("29.1").setChapterDesc("投影")
                .setChapter(1));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 94)
                .setChapterName("29.2").setChapterDesc("三视图")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 104)
                        .setChapterDesc("阅读与思考  视图的产生与应用")
                        .setChapter(1)));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 105)
                .setChapterName("29.3").setChapterDesc("课题学习  制作立体模型")
                .setChapter(3));

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 107)
                .setChapterName("数学活动")
                .setChapter(5));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 108)
                .setChapterName("小结")
                .setChapter(6));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 109)
                .setChapterName("复习题29")
                .setChapter(6));

        /**
         * =============================================
         * ====================附表====================
         * =============================================
         */

        Catalogue catalogueTip = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 112)
                .setChapterName("部分中英文词汇索引")
                .setChapter(30);
        arrayList.add(catalogueTip);

        return arrayList;
    }

    @Override
    public TreeMap<Integer, Catalogue> getCatalogueMap() {
        if (mapDatas != null) {
            return mapDatas;
        }
        List<Catalogue> list = getCatalogueList();
        mapDatas = new TreeMap<>();
        int i = 0;
        for (Catalogue catalogue : list) {
            mapDatas.put(i, catalogue);
            i++;
            int nodeSize = catalogue.getNodeSize();
            if (nodeSize != 0) {
                for (Catalogue node : catalogue.getNodes()) {
                    mapDatas.put(i, node);
                    i++;
                    int smallSize = node.getNodeSize();
                    if (smallSize != 0) {
                        for (Catalogue small : node.getNodes()) {
                            mapDatas.put(i, small);
                            i++;
                        }
                    }
                }
            }
        }
        return mapDatas;
    }

    @Override
    public String[] getHeads() {
        return heads;
    }
}

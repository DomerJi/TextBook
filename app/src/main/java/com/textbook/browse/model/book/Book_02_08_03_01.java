package com.textbook.browse.model.book;

import com.textbook.browse.model.Catalogue;
import com.textbook.browse.model.CatalogueFace;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by v_jishuaipeng on 2020-09-06.
 * 描述: 数学 八年级 下册 人教版 【目录】
 */
public class Book_02_08_03_01 implements CatalogueFace {

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
                .setChapterName("第十六章").setChapterDesc("二次根式")
                .setChapter(16);
        arrayList.add(catalogue);

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 2)
                .setChapterName("16.1").setChapterDesc("二次根式")
                .setChapter(1));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 6)
                .setChapterName("16.2").setChapterDesc("二次根式的乘除")
                .setChapter(2));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 12)
                .setChapterName("16.3").setChapterDesc("二次根式的加减")
                .setChapter(3)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 16)
                        .setChapterDesc("阅读与思考  海伦-秦九韶公式")
                        .setChapter(1)));


        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 17)
                .setChapterName("数学活动")
                .setChapter(4));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 18)
                .setChapterName("小结")
                .setChapter(5));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 19)
                .setChapterName("复习题16")
                .setChapter(6));

        /**
         * =============================================
         * ====================第十七章====================
         * =============================================
         */

        Catalogue catalogue6 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 21)
                .setChapterName("第十七章").setChapterDesc("勾股定理")
                .setChapter(17);
        arrayList.add(catalogue6);

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 22)
                .setChapterName("17.1").setChapterDesc("勾股定理")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 30)
                        .setChapterDesc("阅读与思考  勾股定理的证明")
                        .setChapter(1)));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 31)
                .setChapterName("17.2").setChapterDesc("勾股定理的逆定理")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 35)
                        .setChapterDesc("阅读与思考  费马大定理")
                        .setChapter(1)));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 36)
                .setChapterName("数学活动")
                .setChapter(3));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 37)
                .setChapterName("小结")
                .setChapter(4));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 38)
                .setChapterName("复习题17")
                .setChapter(5));
        /**
         * =============================================
         * ====================第十八章====================
         * =============================================
         */

        Catalogue catalogue7 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 40)
                .setChapterName("第十八章").setChapterDesc("平行四边形")
                .setChapter(18);
        arrayList.add(catalogue7);

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 41)
                .setChapterName("18.1").setChapterDesc("平行四边形")
                .setChapter(1));

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 52)
                .setChapterName("18.2").setChapterDesc("特殊的平行四边形")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 63)
                        .setChapterDesc("阅读与思考  丰富多彩的正方形")
                        .setChapter(1)));

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 64)
                .setChapterName("数学活动")
                .setChapter(3));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 66)
                .setChapterName("小结")
                .setChapter(4));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 67)
                .setChapterName("复习题18")
                .setChapter(5));

        /**
         * =============================================
         * ====================第十九章====================
         * =============================================
         */

        Catalogue catalogue8 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 70)
                .setChapterName("第十九章").setChapterDesc("一次函数")
                .setChapter(19);
        arrayList.add(catalogue8);

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 71)
                .setChapterName("19.1").setChapterDesc("函数")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 85)
                        .setChapterDesc("阅读与思考  科学家如何测算岩石的年龄")
                        .setChapter(1)));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 86)
                .setChapterName("19.2").setChapterDesc("一次函数")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 101)
                        .setChapterDesc("信息技术应用  用计算机画函数图像")
                        .setChapter(1)));

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 102)
                .setChapterName("19.3").setChapterDesc("课题学习  选择方案")
                .setChapter(3));

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 105)
                .setChapterName("数学活动")
                .setChapter(4));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 106)
                .setChapterName("小结")
                .setChapter(5));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 107)
                .setChapterName("复习题19")
                .setChapter(6));

        /**
         * =============================================
         * ====================第二十章====================
         * =============================================
         */

        Catalogue catalogue9 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 110)
                .setChapterName("第二十章").setChapterDesc("数据的分析")
                .setChapter(20);
        arrayList.add(catalogue9);

        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 111)
                .setChapterName("20.1").setChapterDesc("数据的集中趋势")
                .setChapter(1));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 124)
                .setChapterName("20.2").setChapterDesc("一元一次不等式")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 129)
                        .setChapterDesc("阅读与思考  数据波动程度的几种度量")
                        .setChapter(1)));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 131)
                .setChapterName("20.3").setChapterDesc("课题学习  体质健康测试中的数据分析")
                .setChapter(3));

        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 134)
                .setChapterName("数学活动")
                .setChapter(4));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 135)
                .setChapterName("小结")
                .setChapter(5));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 136)
                .setChapterName("复习题9")
                .setChapter(6));


        /**
         * =============================================
         * ====================附表====================
         * =============================================
         */

        Catalogue catalogueTip = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 138)
                .setChapterName("部分中英文词汇索引")
                .setChapter(21);
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

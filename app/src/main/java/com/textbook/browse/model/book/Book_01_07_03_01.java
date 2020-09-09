package com.textbook.browse.model.book;

import com.textbook.browse.model.Catalogue;
import com.textbook.browse.model.CatalogueFace;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by v_jishuaipeng on 2020-09-06.
 * 描述: 语文 七年级 下册 人教版 【目录】
 */
public class Book_01_07_03_01 implements CatalogueFace {

    private String[] heads = new String[]{"封面", "封面", "目录", "目录", "目录", "目录"};
    private ArrayList<Catalogue> arrayList;
    private TreeMap<Integer, Catalogue> mapDatas;

    @Override
    public List<Catalogue> getCatalogueList() {
        if (arrayList != null) {
            return arrayList;
        }
        arrayList = new ArrayList<>();

        Catalogue catalogue = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 1)
                .setChapterName("第一单元").setChapterDesc("")
                .setChapter(1);
        arrayList.add(catalogue);

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 2)
                .setChapterName("1").setChapterDesc("邓稼先/杨振宁").setAuthor("杨振宁")
                .setChapter(1));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 9)
                .setChapterName("2").setChapterDesc("说和做\n    —  记闻一多先生的言行片段/臧克家").setAuthor("臧克家")
                .setChapter(2));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 13)
                .setChapterName("3*").setChapterDesc("回忆鲁迅先生(节选)/萧红")
                .setChapter(3));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 22)
                .setChapterName("4").setChapterDesc("孙权劝学/《资治通鉴》")
                .setChapter(4));

        catalogue.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 24)
                .setChapterName("写作").setChapterDesc("写出人物的精神")
                .setChapter(5));
        /**
         * =============================================
         * ====================第二单元====================
         * =============================================
         */

        Catalogue catalogue2 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 27)
                .setChapterName("第二单元").setChapterDesc("")
                .setChapter(2);
        arrayList.add(catalogue2);

        catalogue2.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 28)
                .setChapterName("5").setChapterDesc("黄河颂/光未然")
                .setChapter(5));

        catalogue2.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 31)
                .setChapterName("6").setChapterDesc("老山界/陆定一")
                .setChapter(6));

        catalogue2.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 37)
                .setChapterName("7*").setChapterDesc("土地的誓言/端木蕻良")
                .setChapter(7));

        catalogue2.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 41)
                .setChapterName("8").setChapterDesc("木兰诗")
                .setChapter(8));

        catalogue2.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 44)
                .setChapterName("写作").setChapterDesc("学习抒情")
                .setChapter(8));

        catalogue2.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 46)
                .setChapterName("综合性学习").setChapterDesc("天下国家")
                .setChapter(8));

        /**
         * =============================================
         * ====================第三单元====================
         * =============================================
         */


        Catalogue catalogue6 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 49)
                .setChapterName("第三单元").setChapterDesc("")
                .setChapter(6);
        arrayList.add(catalogue6);

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 40)
                .setChapterName("6.1").setChapterDesc("平方根")
                .setChapter(1));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 49)
                .setChapterName("6.2").setChapterDesc("立方根")
                .setChapter(2));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 53)
                .setChapterName("6.3").setChapterDesc("实数")
                .setChapter(3)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 58)
                        .setChapterDesc("阅读与思考  为什么说√2不是有理数")
                        .setChapter(1)));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 59)
                .setChapterName("数学活动")
                .setChapter(4));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 60)
                .setChapterName("小结")
                .setChapter(5));

        catalogue6.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 61)
                .setChapterName("复习题6")
                .setChapter(6));
        /**
         * =============================================
         * ====================第七章====================
         * =============================================
         */

        Catalogue catalogue7 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 63)
                .setChapterName("第七章").setChapterDesc("平面直角坐标系")
                .setChapter(7);
        arrayList.add(catalogue7);

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 64)
                .setChapterName("7.1").setChapterDesc("平面直角坐标系")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 72)
                        .setChapterDesc("阅读与思考  用经纬度表示地理位置")));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 73)
                .setChapterName("7.2").setChapterDesc("坐标方法的简单应用")
                .setChapter(2));

        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 81)
                .setChapterName("数学活动")
                .setChapter(3));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 83)
                .setChapterName("小结")
                .setChapter(4));
        catalogue7.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 84)
                .setChapterName("复习题7")
                .setChapter(5));

        /**
         * =============================================
         * ====================第八章====================
         * =============================================
         */

        Catalogue catalogue8 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 87)
                .setChapterName("第八章").setChapterDesc("二元一次方程组")
                .setChapter(8);
        arrayList.add(catalogue8);

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 88)
                .setChapterName("8.1").setChapterDesc("二元一次方程组")
                .setChapter(1));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 91)
                .setChapterName("8.2").setChapterDesc("消元 —— 解二元一次方程组")
                .setChapter(2));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 99)
                .setChapterName("8.3").setChapterDesc("实际问题与二元一次方程组")
                .setChapter(3));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 103)
                .setChapterName("*8.4").setChapterDesc("三元一次方程组的解法")
                .setChapter(4)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 107)
                        .setChapterDesc("阅读与思考  一次方程组的古今表示及解法")
                        .setChapter(1)));

        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 109)
                .setChapterName("数学活动")
                .setChapter(5));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 110)
                .setChapterName("小结")
                .setChapter(6));
        catalogue8.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 111)
                .setChapterName("复习题8")
                .setChapter(7));

        /**
         * =============================================
         * ====================第九章====================
         * =============================================
         */

        Catalogue catalogue9 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 113)
                .setChapterName("第九章").setChapterDesc("不等式与不等式组")
                .setChapter(9);
        arrayList.add(catalogue9);

        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 114)
                .setChapterName("9.1").setChapterDesc("不等式")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 121)
                        .setChapterDesc("阅读与思考  用求差法比较大小")
                        .setChapter(1)));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 122)
                .setChapterName("9.2").setChapterDesc("一元一次不等式")
                .setChapter(2));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 127)
                .setChapterName("9.3").setChapterDesc("一元一次不等式组")
                .setChapter(3));

        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 131)
                .setChapterName("数学活动")
                .setChapter(4));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 132)
                .setChapterName("小结")
                .setChapter(5));
        catalogue9.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 133)
                .setChapterName("复习题9")
                .setChapter(6));

        /**
         * =============================================
         * ====================第十章====================
         * =============================================
         */

        Catalogue catalogue10 = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 134)
                .setChapterName("第十章").setChapterDesc("数据的收集、整理与描述")
                .setChapter(10);
        arrayList.add(catalogue10);

        catalogue10.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 135)
                .setChapterName("10.1").setChapterDesc("统计调查")
                .setChapter(1)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 144)
                        .setChapterDesc("实验与探究  瓶子中有多少粒豆子")
                        .setChapter(1)));
        catalogue10.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 145)
                .setChapterName("10.2").setChapterDesc("直方图")
                .setChapter(2)
                .addNode(new Catalogue(CatalogueFace.TYPE_SMALLNODE, 151)
                        .setChapterDesc("信息技术应用  利用计算机画统计图")
                        .setChapter(1)));
        catalogue10.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 153)
                .setChapterName("10.3").setChapterDesc("课题学习  从数据谈节水")
                .setChapter(3));

        catalogue10.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 156)
                .setChapterName("数学活动")
                .setChapter(4));
        catalogue10.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 157)
                .setChapterName("小结")
                .setChapter(5));
        catalogue10.addNode(new Catalogue(CatalogueFace.TYPE_NODE, 158)
                .setChapterName("复习题10")
                .setChapter(6));

        /**
         * =============================================
         * ====================附表====================
         * =============================================
         */

        Catalogue catalogueTip = new Catalogue(CatalogueFace.TYPE_CATALOGUE, 162)
                .setChapterName("部分中英文词汇索引")
                .setChapter(11);
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

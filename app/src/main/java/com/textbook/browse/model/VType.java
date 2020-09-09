package com.textbook.browse.model;

/**
 * Created by v_jishuaipeng on 2020-09-03.
 * 描述:
 */
public class VType {
    public static final String UNKNOWN = "unknown";

    public static String getType(int type) {
        switch (type) {
            case 1:
                return "人民教育出版社";
            default:
                return UNKNOWN;
        }

    }

    public static String getCourse(int course) {
        switch (course) {
            case Course.MATHEMATICS:
                return "数学";
            case Course.ENGLISH:
                return "英语";
            case Course.CHINESE:
                return "语文";
            default:
                return UNKNOWN;
        }
    }

    public static String getVolume(int volume) {
        switch (volume) {
            case Volume.ALL:
                return "全集";
            case Volume.DOWN:
                return "下册";
            case Volume.UP:
                return "上册";
            case Volume.MIDDLE:
                return "中册";
            default:
                return UNKNOWN;
        }
    }

    public static String getNumber(int number) {

        switch (number) {
            case 0:
                return "";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            default:
                return UNKNOWN;
        }
    }
}

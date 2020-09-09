package com.textbook.browse.model;

import android.text.TextUtils;

/**
 * Created by v_jishuaipeng on 2020-09-03.
 * 描述: 教科书实体类
 */
public class Album {

    public Album(String path) {
        this.path = path;
        this.course = Course.NORMAL;
        this.volume = Volume.ALL;
    }

    public Album() {
        this.course = Course.NORMAL;
        this.volume = Volume.ALL;
    }


    // 路径
    private String path;

    // 名称
    private String name;

    // 简介
    private String desc;

    /**
     * 出版社 {@link VType}
     */
    private int type;

    // 第几版
    private int version;

    // 年级
    private int grade;

    /**
     * 上下册 {@link Volume}
     * 默认 {@link Volume#ALL}
     */
    private int volume;

    /**
     * 学科 {@link Course}
     * 默认 {@link Course#NORMAL}
     */
    private int course;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        if (TextUtils.isEmpty(name)) {
            name = VType.getCourse(course) + " "
                    + VType.getNumber(getGrade()) + "年级 "
                    + VType.getVolume(volume);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        if (TextUtils.isEmpty(desc)) {
            desc = VType.getType(type);
        }
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album) {
            return TextUtils.equals(path, ((Album) obj).path);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Album{" +
                "path='" + path + '\'' +
                ", name='" + getName() + '\'' +
                ", desc='" + getDesc() + '\'' +
                ", type=" + type +
                ", version=" + version +
                ", grade=" + grade +
                ", volume=" + volume +
                ", course=" + course +
                '}';
    }
}

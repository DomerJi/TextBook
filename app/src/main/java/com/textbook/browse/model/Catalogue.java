package com.textbook.browse.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_jishuaipeng on 2020-09-05.
 * 描述:
 */
public class Catalogue {

    public String chapterName;
    public int chapter;
    public String chapterDesc;
    public String author;

    public List<Catalogue> nodes;

    private int page;
    // 章 0;节 1; 小节 2; ...
    private int type;

    public Catalogue(int type, int page) {
        this.type = type;
        this.page = page;
    }

    public Catalogue setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public int getType() {
        return type;
    }

    public int getPage() {
        return page;
    }

    public Catalogue setChapterName(String chapterName) {
        this.chapterName = chapterName;
        return this;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public Catalogue setChapter(int chapter) {
        this.chapter = chapter;
        return this;
    }

    public int getChapter() {
        return chapter;
    }

    public Catalogue setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
        return this;
    }

    public Catalogue addNode(Catalogue node) {
        if (node != null) {
            if (this.nodes == null) {
                this.nodes = new ArrayList<>();
            }
            this.nodes.add(node);
        }
        return this;
    }

    public List<Catalogue> getNodes() {
        return nodes;
    }

    public int getNodeSize() {
        return nodes == null ? 0 : nodes.size();
    }
}

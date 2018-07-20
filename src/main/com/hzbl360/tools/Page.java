package com.hzbl360.tools;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Page<T> {

    //当前页
    private int currentPage = 1;

    //当前的起始索引 (起始行数)
    private int start;

    //每页大小 (每页显示行数)
    private int pageSize = 2;

    //总页数
    private int pageTotal;

    //第一页
    private int firstPage = 1;

    //最后一页
    private int lastPage;

    //每页内容
    private List<T> content;


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = (this.currentPage -1) * pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", start=" + start +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", content=" + content +
                '}';
    }
}

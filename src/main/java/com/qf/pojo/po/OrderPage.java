package com.qf.pojo.po;

import java.util.List;

public class OrderPage {
    private int currentPage=1;
    private int pageSize=10;
    private int pageCount;
    private int offset;
    private int totalPage;
    private int begin;
    private int end;
    private List<Order> date;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public OrderPage() {
    }

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

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<Order> getDate() {
        return date;
    }

    public void setDate(List<Order> date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderPage{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", offset=" + offset +
                ", totalPage=" + totalPage +
                ", begin=" + begin +
                ", end=" + end +
                ", date=" + date +
                '}';
    }
}

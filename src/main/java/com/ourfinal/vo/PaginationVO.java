package com.ourfinal.vo;

import java.util.List;

//将来分页查询每个模块都有，所以用通用vo比较方便
public class PaginationVO<T> {
    private Integer total;
    private List<T> dataList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}

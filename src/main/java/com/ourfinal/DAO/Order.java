package com.ourfinal.DAO;

public class Order {
    private String oid;
    private String orderName;
    private Integer orderNum;
    private Float total;
    private String userId;
    private String goodsId;

    public Order() {
    }

    public Order(String oid, String orderName, Integer orderNum, Float total, String userId, String goodsId) {
        this.oid = oid;
        this.orderName = orderName;
        this.orderNum = orderNum;
        this.total = total;
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}

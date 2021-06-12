package com.ourfinal.DAO;

public class ShopCar {
    private String cid;
    private String goodsName;
    private Integer goodsNum;
    private Float countCost;
    private Float total;
    private String userId;
    private String fileName;
    private String goodsid;
    public ShopCar() {
    }

    public ShopCar(String cid, String goodsName, Integer goodsNum, Float countCost, Float total, String userId, String fileName, String goodsid) {
        this.cid = cid;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.countCost = countCost;
        this.total = total;
        this.userId = userId;
        this.fileName = fileName;
        this.goodsid = goodsid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Float getCountCost() {
        return countCost;
    }

    public void setCountCost(Float countCost) {
        this.countCost = countCost;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }
}

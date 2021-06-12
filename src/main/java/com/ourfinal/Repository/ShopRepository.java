package com.ourfinal.Repository;

import com.ourfinal.DAO.Order;
import com.ourfinal.DAO.ShopCar;

import java.util.List;

public interface ShopRepository {
    int addGoodsToCarById(ShopCar shopCar);

    List<ShopCar> ShopCarListByUserId(String id);

    int findShopCarCount(String[] id);

    int deleteShopCarByIds(String[] id);


    List<ShopCar> findshopCarById(String[] id);

    int insertOrderByOrder(Order order);
}

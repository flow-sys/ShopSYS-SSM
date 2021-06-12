package com.ourfinal.Service;

import com.ourfinal.DAO.ShopCar;
import com.ourfinal.exeption.DeleteException;
import com.ourfinal.exeption.InsertException;

import java.util.List;

public interface ShopService {
    boolean addGoodsToCar(String[] id, String userId) throws InsertException;

    List<ShopCar> ShopCarListByUserId(String id);

    boolean deleteShopCarByIds(String[] id) throws DeleteException;

    boolean settlementById(String[] id, String userId) throws Exception;
}

package com.ourfinal.Service.Impl;

import com.ourfinal.DAO.Goods;
import com.ourfinal.DAO.Order;
import com.ourfinal.DAO.ShopCar;
import com.ourfinal.Repository.GoodsRepository;
import com.ourfinal.Repository.ShopRepository;
import com.ourfinal.Service.ShopService;
import com.ourfinal.exeption.DeleteException;
import com.ourfinal.exeption.InsertException;
import com.ourfinal.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopRepository shopRepository;
    @Resource
    private GoodsRepository goodsRepository;

    @Override
    @Transactional
    public boolean addGoodsToCar(String[] ids, String userId) throws InsertException {
        boolean flag = true;
        Goods goods = null;
        for(String id:ids){
            goods = goodsRepository.findGoodsById(id);
            String cid = UUIDUtil.getUUID();
            ShopCar shopCar = new ShopCar(cid,goods.getName(),1,
                    goods.getPrice(),goods.getPrice(),userId,goods.getFileName(),goods.getId());
            int cout = shopRepository.addGoodsToCarById(shopCar);
            if(cout != 1){
                throw new InsertException();
            }
        }
        return flag;
    }

    @Override
    public List<ShopCar> ShopCarListByUserId(String id) {
        List<ShopCar> scList = shopRepository.ShopCarListByUserId(id);
        return scList;
    }

    @Override
    @Transactional
    public boolean deleteShopCarByIds(String[] id) throws DeleteException {
        boolean flag = true;
        int count1 = shopRepository.findShopCarCount(id);
        int count2 = shopRepository.deleteShopCarByIds(id);
        if(count1 != count2){
            throw new DeleteException();
        }
        return flag;
    }

    @Override
    @Transactional
    public boolean settlementById(String[] id, String userId) throws Exception{
        boolean flag = true;
        List<ShopCar> scList = shopRepository.findshopCarById(id);
        int count = 0;
        for(ShopCar shopCar:scList){
            String oid = UUIDUtil.getUUID();
            Order order = new Order(oid,shopCar.getGoodsName(),shopCar.getGoodsNum(),
                    shopCar.getTotal(),userId,shopCar.getGoodsid());
            count = shopRepository.insertOrderByOrder(order);
            if(count != 1){
                throw new InsertException();
            }
        }
        int count2 = shopRepository.findShopCarCount(id);
        int count3 = shopRepository.deleteShopCarByIds(id);
        if(count2 != count3){
            throw new DeleteException();
        }
        return flag;
    }
}

package com.ourfinal.Service.Impl;

import com.ourfinal.DAO.Goods;
import com.ourfinal.Repository.GoodsRepository;
import com.ourfinal.Service.GoodsService;
import com.ourfinal.exeption.DeleteException;
import com.ourfinal.exeption.InsertException;
import com.ourfinal.exeption.RepeatIdException;
import com.ourfinal.exeption.UpdateException;
import com.ourfinal.vo.PaginationVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsRepository goodsRepository;

    @Override
    public boolean addGoods(Goods goods) throws Exception{
        boolean flag = true;
        Goods goods1 = goodsRepository.findGoodsById(goods.getId());
        if(goods1 != null){
            throw new RepeatIdException();
        }
        int count = goodsRepository.addGoods(goods);
        if(count != 1){
            throw new InsertException();
        }
        return flag;
    }

    @Override
    @Transactional
    public PaginationVO<Goods> pageList(Goods goods, Integer pageNo, Integer pageSize) {
        Integer skipPages = (pageNo-1)*pageSize;
        Map<String,Object> map = new HashMap<>();
        map.put("goods",goods);
        map.put("skipPages",skipPages);
        map.put("pageSize",pageSize);
        int total = goodsRepository.findAllGoodsCount(goods);
        List<Goods> gList= goodsRepository.pageList(map);
        PaginationVO<Goods> vo = new PaginationVO<>();
        vo.setDataList(gList);
        vo.setTotal(total);
        return vo;
    }

    @Override
    public Goods getGoodsInfoById(String id) {
        Goods goods = goodsRepository.findGoodsById(id);
        return goods;
    }

    @Override
    @Transactional
    public boolean updateGoodsByIdSaveBeforeId(Goods goods, String beforeId) throws Exception {
        boolean flag = true;
        if(beforeId.equals(goods.getId())){
            int count1 = goodsRepository.updateGoodsById(goods);
            if(count1 != 1){
                throw new UpdateException();
            }
        }else{
            Goods goods1 = goodsRepository.findGoodsById(goods.getId());
            if(goods1 != null){
                throw new RepeatIdException();
            }
            Map<String,Object> map = new HashMap<>();
            map.put("goods",goods);
            map.put("beforeId",beforeId);
            int count2 = goodsRepository.updateGoodsByBeforeId(map);
            if(count2 != 1){
                throw new UpdateException();
            }
        }
        return flag;
    }

    @Override
    @Transactional
    public boolean deleteGoodsByIds(String[] id) throws DeleteException {
        boolean flag = true;
        int count1 = goodsRepository.findDeleteGoodsCount(id);
        int count2 = goodsRepository.deleteGoodsByIds(id);
        if(count1 != count2){
            throw new DeleteException();
        }
        return flag;
    }

}

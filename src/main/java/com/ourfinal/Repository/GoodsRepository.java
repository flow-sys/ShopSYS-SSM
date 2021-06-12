package com.ourfinal.Repository;

import com.ourfinal.DAO.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsRepository {
    int addGoods(Goods goods);

    int findAllGoodsCount(Goods goods);

    List<Goods> pageList(Map<String, Object> map);

    Goods findGoodsById(String id);

    int updateGoodsById(Goods goods);

    int updateGoodsByBeforeId(Map<String, Object> map);

    int findDeleteGoodsCount(String[] param);

    int deleteGoodsByIds(String[] param);
}

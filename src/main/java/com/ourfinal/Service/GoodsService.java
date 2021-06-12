package com.ourfinal.Service;

import com.ourfinal.DAO.Goods;
import com.ourfinal.exeption.DeleteException;
import com.ourfinal.vo.PaginationVO;

    public interface GoodsService {
    boolean addGoods(Goods goods) throws Exception;

    PaginationVO<Goods> pageList(Goods goods, Integer pageNo, Integer pageSize);

    Goods getGoodsInfoById(String id);

    boolean updateGoodsByIdSaveBeforeId(Goods goods, String beforeId) throws Exception;

        boolean deleteGoodsByIds(String[] id) throws DeleteException;
    }

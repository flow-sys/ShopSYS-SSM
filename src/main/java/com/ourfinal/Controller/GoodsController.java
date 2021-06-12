package com.ourfinal.Controller;

import com.ourfinal.DAO.Goods;
import com.ourfinal.DAO.User;
import com.ourfinal.Service.GoodsService;
import com.ourfinal.exeption.DeleteException;
import com.ourfinal.utils.DateTimeUtil;
import com.ourfinal.vo.PaginationVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping("/addGoods.do")
    public Map<String,Object> addGoods(Goods goods, HttpServletRequest request){
        String editBy = ((User)request.getSession().getAttribute("user")).getName();
        String editTime = DateTimeUtil.getSysTime();
        goods.setEditBy(editBy);
        goods.setEditTime(editTime);
        Map<String,Object> map = new HashMap<>();
        try {
            boolean flag = goodsService.addGoods(goods);
            map.put("success",flag);
            return map;
        } catch (Exception e) {
            map.put("success",false);
            System.out.println(e.getMessage());
            map.put("msg", e.getMessage());
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/pageList.do")
    public PaginationVO<Goods> pageList(Goods goods,Integer pageNo,Integer pageSize){
        PaginationVO<Goods> vo = goodsService.pageList(goods,pageNo,pageSize);
        return vo;
    }

    @ResponseBody
    @RequestMapping("/getGoodsInfoById.do")
    public Goods getGoodsInfoById(String id){
        Goods goods = goodsService.getGoodsInfoById(id);
        return goods;
    }

    @ResponseBody
    @RequestMapping("/updateGoodsByIdSaveBeforeId.do")
    public Map<String,Object> updateGoodsByIdSaveBeforeId(Goods goods,String beforeId,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String editTime = DateTimeUtil.getSysTime();
        String editBy = ((User)request.getSession().getAttribute("user")).getName();
        goods.setEditTime(editTime);
        goods.setEditBy(editBy);
        try {
            boolean flag = goodsService.updateGoodsByIdSaveBeforeId(goods,beforeId);
            map.put("success",flag);
            return map;
        } catch (Exception e) {
            map.put("success",false);
            map.put("msg",e.getMessage());
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/deleteGoodsByIds.do")
    public Map<String,Object> deleteGoodsByIds(String[] id){
        Map<String,Object> map = new HashMap<>();
        try {
            boolean flag = goodsService.deleteGoodsByIds(id);
            map.put("success",true);
            return map;
        } catch (DeleteException e) {
            map.put("success",false);
            map.put("msg",e.getMessage());
            return map;
        }

    }
}

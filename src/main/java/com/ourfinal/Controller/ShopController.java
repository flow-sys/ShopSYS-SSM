package com.ourfinal.Controller;

import com.ourfinal.DAO.ShopCar;
import com.ourfinal.DAO.User;
import com.ourfinal.Service.ShopService;
import com.ourfinal.exeption.DeleteException;
import com.ourfinal.exeption.InsertException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Resource
    private ShopService shopService;

    @ResponseBody
    @RequestMapping("/addGoodsToCar.do")
    public Map<String,Object> addGoodsToCar(String[] ids, HttpServletRequest request){
        String userId = ((User)request.getSession().getAttribute("user")).getId();
        Map<String,Object> map = new HashMap<>();
        try {
            boolean flag = shopService.addGoodsToCar(ids,userId);
            map.put("success",flag);
            return map;
        } catch (InsertException insertException) {
            map.put("success",false);
            map.put("msg",insertException.getMessage());
            return map;
        }
    }

    @RequestMapping("/goShopCar.do")
    public ModelAndView goShopCar(HttpServletRequest request){
        String id = ((User)request.getSession().getAttribute("user")).getId();
        ModelAndView mv = new ModelAndView();
        List<ShopCar> scList = shopService.ShopCarListByUserId(id);
        mv.addObject("scList",scList);
        mv.setViewName("car");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/deleteShopCarByIds.do")
    public Map<String,Object> deleteShopCarByIds(String[] id){
        Map<String,Object> map = new HashMap<>();
        try {
            boolean flag = shopService.deleteShopCarByIds(id);
            map.put("success",true);
            return map;
        } catch (DeleteException e) {
            map.put("success",false);
            map.put("msg",e.getMessage());
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/settlementById.do")
    public Map<String,Object> settlementById(String[] id,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String userId = ((User)request.getSession().getAttribute("user")).getId();
        try {
            boolean flag = shopService.settlementById(id,userId);
            map.put("success",true);
            return map;
        } catch (Exception e) {
            map.put("success",false);
            map.put("msg",e.getMessage());
            return map;
        }
    }
}

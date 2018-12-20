package com.qf.web;

import com.qf.dao.OrderDao;
import com.qf.pojo.po.LayuiReplay;
import com.qf.pojo.po.Order;
import com.qf.pojo.po.OrderPage;
import com.qf.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ActionOrder {
     @Autowired
    private OrderService orderService;

     @RequestMapping(value ="/orders")
     @ResponseBody
    public LayuiReplay allOrders(String cname, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit){
          LayuiReplay layuiReplay = orderService.showOrders(cname,page,limit);
          return layuiReplay;
     }
     @RequestMapping(value = "/orderDelete" )
     @ResponseBody
    public LayuiReplay orderDelete(String  oid){
       //  System.out.println(oid+"====================================================");
          LayuiReplay layuiReplay = new LayuiReplay();
                boolean flag=  orderService.deleteOrderById(oid);
         if(!flag){
             layuiReplay.setCode(-1);
         }else{
             layuiReplay.setCode(0);
         }
         return layuiReplay;
     }
    @RequestMapping(value = "/getOrder")
    @ResponseBody
    public Order findOrder(String oid){
         Order order = new Order();
         order = orderService.findOrder(oid);
        System.out.println(order);
         return order;
    }

    @RequestMapping(value = "/toOrderUpdate")
    @ResponseBody
    public LayuiReplay toUpdateOrder(Order order){
         LayuiReplay layuiReplay = new LayuiReplay();
         int i = orderService.toUpdateOrder(order);
         if(i==0){
             //修改失败
             layuiReplay.setCode(-1);
         }else{
             layuiReplay.setCode(0);
         }
         return layuiReplay;
    }
     @RequestMapping(value = "/deleteByOid")
     @ResponseBody
     public String deleteByOid(String oid){
      boolean fuck = orderService.deleteOrderById(oid);
      String json= "{\"meg\":\"ok\"}";
        if(fuck){
            return json;
        }else{
            return "GG";
        }

     }
      @RequestMapping(value = "/addOrder")
      @ResponseBody
      public LayuiReplay AddOrder(Order order){
            LayuiReplay layuiReplay = new LayuiReplay();
          UUID uuid = UUID.randomUUID();
          String oid = uuid.toString();
          order.setOid(oid);
         int a= orderService.addOrder(order);
         System.out.println(order);
            layuiReplay.setCode(0);
            return layuiReplay;
      }

    @RequestMapping(value = "/orderMain")
    public String showOrderMain(OrderPage orderPage,Model model){
         //为offset赋值
         orderPage.setOffset((orderPage.getCurrentPage()-1)*orderPage.getPageSize());
         //得到所有的数据,通过分页的方式
        List<Order>  list  = orderService.findAllOrders(orderPage);
        orderPage.setDate(list);
        //得到总的数量
        List<Order> listCount = orderService.findall();
        int count  = listCount.size();
       // System.out.println(count+"==============================================================================");
        //算出总页数
        orderPage.setTotalPage((count-orderPage.getPageSize())/orderPage.getPageSize());
      //  System.out.println(orderPage.getTotalPage());
        if (orderPage.getTotalPage()<=10){
            orderPage.setBegin(1);
            orderPage.setEnd(orderPage.getTotalPage());
        }else{
            //当总的页数大于10的时候
             if(orderPage.getCurrentPage()<=5 ){

                 orderPage.setBegin(1);
                 orderPage.setEnd(10);

             }
            if(orderPage.getCurrentPage()>5 & orderPage.getCurrentPage()<=10 ){

                orderPage.setBegin(orderPage.getCurrentPage()-5);
                orderPage.setEnd(orderPage.getCurrentPage()+5);

            }

            if(orderPage.getCurrentPage()>10 && ((orderPage.getCurrentPage()+5)<orderPage.getTotalPage())){
                      //

                orderPage.setBegin(orderPage.getCurrentPage()-5);
                orderPage.setEnd(orderPage.getCurrentPage()+5);
            }
            if(orderPage.getCurrentPage()>10 && ((orderPage.getCurrentPage()+5)>orderPage.getTotalPage())){
                //

                orderPage.setBegin(orderPage.getCurrentPage()-5);
                orderPage.setEnd(orderPage.getTotalPage());
            }
        }
       // System.out.println(orderPage);
        model.addAttribute("orderPage",orderPage);
        return "orderMain";
    }
}

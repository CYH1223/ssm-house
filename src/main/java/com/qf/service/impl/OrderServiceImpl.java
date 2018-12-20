package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.pojo.po.LayuiReplay;
import com.qf.pojo.po.Order;
import com.qf.pojo.po.OrderPage;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public LayuiReplay showOrders(String cname,Integer page,Integer limit) {
        LayuiReplay layuiReplay = new LayuiReplay();
         page = (page-1)*limit;
        //找到所有的order订单
        List<Order> list  = orderDao.showOrders(cname,page,limit);
      //  System.out.println(list+"============================================================================================");
      //接下来就是秀分页的操作了
        layuiReplay.setData(list);
        layuiReplay.setCode(0);
        long count = orderDao.countOrder(cname);
        layuiReplay.setCount(count);
        layuiReplay.setMsg("请求成功");
        return layuiReplay;
    }

    @Override
    public boolean deleteOrderById(String oid) {

             return orderDao.deleteOrderById(oid);
    }

    @Override
    public Order findOrder(String oid) {
        return orderDao.findOrder(oid);
    }

    @Override
    public int toUpdateOrder(Order order) {
        return orderDao.toUpdateOrder(order);
    }

    @Override
    public List<Order> findAllOrders(OrderPage orderPage) {
        return orderDao.findAllorders(orderPage);
    }

    @Override
    public List<Order> findall() {
        return orderDao.findAll();
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }
}

package com.qf.service;

import com.qf.pojo.po.LayuiReplay;
import com.qf.pojo.po.Order;
import com.qf.pojo.po.OrderPage;

import java.util.List;

public interface OrderService {
     LayuiReplay showOrders(String cname,Integer page,Integer limit) ;

     boolean deleteOrderById(String oid);

    Order findOrder(String oid);

    int toUpdateOrder(Order order);

    List<Order> findAllOrders(OrderPage orderPage);

    List<Order> findall();

    int addOrder(Order order);
}

package com.qf.dao;

import com.qf.pojo.po.Order;
import com.qf.pojo.po.OrderPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

     List<Order> showOrders( @Param("cname") String cname,@Param("offset") Integer offset,@Param("limit") Integer limit);

    long countOrder(@Param("cname") String cname);

    boolean deleteOrderById(@Param("oid") String oid);

    Order findOrder(@Param("oid") String oid);

    int toUpdateOrder(Order order);

    List<Order> findAllorders(OrderPage orderPage);

    List<Order> findAll();

    int addOrder(Order order);
}

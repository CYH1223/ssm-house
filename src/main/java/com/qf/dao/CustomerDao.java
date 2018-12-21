package com.qf.dao;

import com.qf.pojo.po.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    /**
     * 分页
     * @param cname 客户姓名
     * @param page  当前页
     * @param limit  每页显示的条数
     * @return
     */
    List<Customer> listCustomers(@Param("cname") String cname, @Param("page") Integer page,@Param("limit") Integer limit);

    /**
     * 查询客户数量
     * @param cname 客户姓名
     * @return long
     */
    Long queryCount(@Param("cname") String cname);

    /**
     * 根据ID查询客户
     * @param cid  客户编号
     * @return Customer
     */
    Customer getCustomerById(String cid);

    /**
     * 更新客户
     * @param customer 实体对象
     * @return  boolean
     */
    boolean saveCustomer(Customer customer);

    /**
     * 根据ID删除客户
     * @param cid 客户编号
     * @return   boolean 布尔值
     */
    boolean deleteCustomerById(String cid);

    /**
     * 添加客户
     * @param customer 实体对象
     * @return boolean 布尔值
     */
    boolean insertCustomer(Customer customer);

    /**
     * 查询租户人数
     * @return long
     */
    Long count();

    List<Customer> queryCustomer(@Param(" currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Customer getCustomerByName(@Param("cname") String cname);
}

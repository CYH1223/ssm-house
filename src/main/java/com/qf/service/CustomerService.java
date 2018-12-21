package com.qf.service;

import com.qf.pojo.po.Customer;
import com.qf.pojo.po.LayuiReplay;
import com.qf.util.PageBean;

public interface CustomerService {
    LayuiReplay showAllCustomerPages(String cname, Integer page, Integer limit);

    Customer queryCustomerById(String cid);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomerById(String cid);

    boolean addCustomer(Customer customer);

    PageBean<Customer> showAllCustomer(Integer currentPage, Integer pageSize);

    Customer queryCustomerByCname(String cname);
}

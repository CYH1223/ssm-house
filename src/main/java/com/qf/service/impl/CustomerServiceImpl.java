package com.qf.service.impl;

import com.qf.dao.CustomerDao;
import com.qf.pojo.po.Customer;
import com.qf.pojo.po.LayuiReplay;
import com.qf.service.CustomerService;
import com.qf.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Logger logger =LoggerFactory.getLogger(this.getClass());
    @Autowired
     private CustomerDao customerDao;
    @Override
    public LayuiReplay showAllCustomerPages(String cname, Integer page, Integer limit) {
        LayuiReplay layuiReplay=new LayuiReplay();
        page=(page-1)*limit;
        try{
            List<Customer> list=customerDao.listCustomers(cname,page,limit);
            layuiReplay.setData(list);
            Long count=customerDao.queryCount(cname);
            layuiReplay.setCount(count);
            layuiReplay.setMsg("请求成功");
            layuiReplay.setCode(0);
        }catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return layuiReplay;
    }

    @Override
    public Customer queryCustomerById(String cid) {
      Customer customer=null;
        try{
            customer=customerDao.getCustomerById(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
         boolean b=false;
        try{
           b=customerDao.saveCustomer(customer);
        }catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean deleteCustomerById(String cid) {
        boolean b=false;
        try{
            b=customerDao.deleteCustomerById(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean b=false;
        try{
            Long count=customerDao.count();
            customer.setNum(count);
            b=customerDao.insertCustomer(customer);
        }catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public PageBean<Customer> showAllCustomer(Integer currentPage, Integer pageSize) {
        currentPage=(currentPage-1)*pageSize;
        PageBean<Customer> pageBean=new PageBean();
        try{
            List<Customer> customers=customerDao.queryCustomer(currentPage,pageSize);
            pageBean.setCurrentPage(currentPage);
            pageBean.setList(customers);
            pageBean.setPageSize(pageSize);
            Long count=customerDao.count();
            pageBean.setTotalCount(count);
            Long total=(count%pageSize==0?(count/pageSize):(count/pageSize)+1);
            pageBean.setTotalPage(total);
        }
        catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return pageBean;
    }

    @Override
    public Customer queryCustomerByCname(String cname) {
        Customer customer=null;
        try{
            customer=customerDao.getCustomerByName(cname);
        }catch (Exception e){
            logger.error(e.getMessage(),e) ;
            e.printStackTrace();
        }
        return customer;
    }
}

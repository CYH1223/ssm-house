package com.qf.web;

import com.qf.pojo.po.Customer;
import com.qf.pojo.po.LayuiReplay;
import com.qf.service.CustomerService;
import com.qf.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 客户分页
     * @param cname
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/customers")
    @ResponseBody
    public LayuiReplay showAllCustomerPages(String cname, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue ="10") Integer limit){
        LayuiReplay layuiReplay=customerService.showAllCustomerPages(cname,page,limit);
        return layuiReplay;
    }

    /**
     * 根据ID查询客户
     * @param cid
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCustomer")
    public Customer getCustomer(String cid){
         Customer customer =customerService.queryCustomerById(cid);
        return customer;
    }

    /**
     * 修改客户接口
     * @param customer
     * @return
     */
    @RequestMapping(value = "/toCustomer",produces = "application/json;charset=utf-8")
    @ResponseBody
    public LayuiReplay updateCustomer(Customer customer){
        LayuiReplay layuiReplay=new LayuiReplay();
        boolean b=customerService.updateCustomer(customer);
        if(!b){
            layuiReplay.setCode(-1);
        }
        return  layuiReplay;
    }

    /**
     * 删除客户，根据ID删除客户
     * @param cid
     * @return LayuiReplay
     */
    @RequestMapping("/customerDel")
    @ResponseBody
    public LayuiReplay deleteCustomer(String cid){
        LayuiReplay layuiReplay=new LayuiReplay();
        boolean b=customerService.deleteCustomerById(cid);
        if(!b){
          layuiReplay.setCode(-1);
        }
        return  layuiReplay;
    }

    /**
     * 添加客户
     * @param customer
     * @return
     */
    @RequestMapping("/customerAdd")
    @ResponseBody
    public LayuiReplay addCustomer(Customer customer){
        LayuiReplay layuiReplay=new LayuiReplay();
        boolean b=customerService.addCustomer(customer);
        if(!b){
            layuiReplay.setCode(-1);
        }
        return  layuiReplay;
    }
@RequestMapping("/showAllCustomer")
    public String showAllCustomer(Model model, @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "5") Integer pageSize){
     PageBean<Customer> pb=customerService.showAllCustomer(currentPage,pageSize);
     pb.setCurrentPage((pb.getCurrentPage()/pageSize)+1);
        model.addAttribute("pb",pb);
        return "customerlist";
    }
      @RequestMapping("/getCustomerName")
      @ResponseBody
      public Customer queryCustomerName(String cname){
        Customer customer=customerService.queryCustomerByCname(cname);
        return customer;
      }

}

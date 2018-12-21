package com.qf.web;

import com.qf.pojo.po.House;
import com.qf.pojo.po.LayuiReplay;
import com.qf.service.HouseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HouseAction {
    @Autowired
    private HouseService houseService;
    /*查询房屋*/
    @GetMapping("/ListHouse")
    @ResponseBody
    public Object listHouse(String houseType ,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "8") Integer limit){
        LayuiReplay layuiReplay = houseService.ListHouse(houseType, page, limit);
        return layuiReplay;
    }
    /*新增*/
    @PostMapping("/SeveHouse")
    @ResponseBody
    public int seveHouse(House house){
      int i=houseService.SeveHouse(house);
        return i;
    }
    /*删除*/
    @GetMapping("/delete")
    @ResponseBody
    public int deleteStudent(@RequestParam("hid") String hid){
       int i = houseService.deleteStudentByID(hid);
        return i;
    }
    /*编辑*/
    @PostMapping("/getHouse")
    @ResponseBody
    public House findHouse(String hid){
        House house = houseService.findHouse(hid);
        return house;
    }
    @PostMapping("/edit")
    @ResponseBody
    public int editStudent(House house){
        /*LayuiReplay layuiReplay = new LayuiReplay();*/
       int i= houseService.editStudentById(house);
       /*if(i==1){
           layuiReplay.setCode(1);
       }*/
      return i;
    }
    /*前端页面数据显示*/
    @GetMapping("/IndexHouse")
    public String IndexHouse(Model model){
        List<House> house = houseService.IndexHouse();
        model.addAttribute("house",house);
        return "HouseIndex";
    }

}

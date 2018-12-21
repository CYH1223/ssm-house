package com.qf.service;

import com.qf.pojo.po.House;
import com.qf.pojo.po.LayuiReplay;

import java.util.List;

public interface HouseService {
    //查询所有商品
    LayuiReplay ListHouse(String houseType, Integer offset, Integer limit);
    //增加房屋
    int SeveHouse(House house);
    //删除房屋数据
    int deleteStudentByID(String hid);
    // 编辑房屋数据
    House findHouse(String hid);
    int editStudentById(House house);
    //查询前端房屋数据
    List<House> IndexHouse();
}

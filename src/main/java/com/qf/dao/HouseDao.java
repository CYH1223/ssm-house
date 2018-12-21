package com.qf.dao;

import com.qf.pojo.po.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseDao {
    //查询所有房屋
    List<House> ListHouse(@Param("houseType") String houseType, @Param("offset") Integer offset, @Param("limit") Integer limit);
    //搜索查询
    long countHouse(@Param("houseType") String houseType);
    //增加房屋
    int SeveHouse(House house);
    //删除学生数据
    int deleteStudentByID(String hid);
    // 编辑房屋数据
    House findHouse(@Param("hid") String hid);
    int editStudentById(House house);
    //查询前端房屋数据
    List<House> IndexHouse();

}

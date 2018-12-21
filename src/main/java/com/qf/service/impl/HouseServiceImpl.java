package com.qf.service.impl;

import com.qf.dao.HouseDao;
import com.qf.pojo.po.House;
import com.qf.pojo.po.LayuiReplay;
import com.qf.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HouseServiceImpl implements HouseService {
    private final static Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
    @Autowired
    private HouseDao HouseDao;
    //分页查询
    @Override
    public LayuiReplay ListHouse(String houseType, Integer page, Integer limit) {
        LayuiReplay layuiReplay =new LayuiReplay();
        int offset = (page - 1) * limit;
        try {
            List<House> houseList = HouseDao.ListHouse(houseType, offset, limit);
            layuiReplay.setData(houseList);
            layuiReplay.setCode(0);
            long count = HouseDao.countHouse(houseType);
            layuiReplay.setCount(count);
            layuiReplay.setMsg("请求成功");
        }catch (Exception e){
            logger.info(e.getMessage(), e);
            e.printStackTrace();
        }
        return layuiReplay;
    }


    //新增
    @Override
    public int SeveHouse(House house) {
        int i=0;
        try {
             i = HouseDao.SeveHouse(house);
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
    //删除
    @Override
    public int deleteStudentByID(String hid) {
        int i=0;
        try {
           i= HouseDao.deleteStudentByID(hid);
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
    //修改
    @Override
    public House findHouse(String hid) {
      House fandHouse=null;
      try {
         fandHouse= HouseDao.findHouse(hid);
      }catch (Exception e){
          logger.info(e.getMessage(),e);
          e.printStackTrace();
      }
        return fandHouse;
    }
    @Override
    public int editStudentById(House house) {
        int i=0;
        try {
            i= HouseDao.editStudentById(house);
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }

    ///查询前端房屋数据
    @Override
    public List<House> IndexHouse() {
        List<House> IndexHouse=null;
        try {
             IndexHouse = HouseDao.IndexHouse();
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            e.printStackTrace();
        }
        return IndexHouse;
    }
}

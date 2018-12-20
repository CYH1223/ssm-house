package com.qf.service.impl;

import com.qf.dao.DepositDao;
import com.qf.pojo.po.Deposit;
import com.qf.pojo.po.LayuiReplay;
import com.qf.service.DepositService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositDao depositDao;

    // 定义日志类
    private final static Logger logger = LoggerFactory.getLogger(DepositServiceImpl.class);

    /*后台实现+++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // 分页查询所有
    @Override
    public LayuiReplay listAllDepositByPage(String cname, Integer page, Integer limit) {
        LayuiReplay layuiReplay = new LayuiReplay();
        List<Deposit> listDeposit = null;
        page = (page - 1) * limit;
        try {
            listDeposit = depositDao.listAllDepositByPage(cname, page, limit);
            layuiReplay.setData(listDeposit);
            layuiReplay.setCode(0);
            long count = depositDao.getDepositTotalCount(cname);
            layuiReplay.setCount(count);
            layuiReplay.setMsg("请求成功");
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            e.printStackTrace();
        }
        return layuiReplay;
    }

    // 删除
    @Override
    public boolean deleteDepositById(int did) {
        boolean b = false;
        try {
            b = depositDao.deleteDepositById(did);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            e.printStackTrace();
        }
        return b;
    }

    // 编辑之查询
    @Override
    public Deposit findDepositById(int did) {
        return depositDao.findDepositById(did);
    }

    // 编辑
    @Override
    public boolean updateDeposit(Deposit deposit) {
        boolean b = false;
        try {
            b = depositDao.updateDeposit(deposit);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            e.printStackTrace();
        }
        return b;
    }

    /*前台实现+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    @Override
    public List<Deposit> showAllDeposit() {
        List<Deposit> deposits = null;
        try {
            deposits = depositDao.showAllDeposit();
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            e.printStackTrace();
        }
        return deposits;
    }
}

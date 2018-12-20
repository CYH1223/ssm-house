package com.qf.service;

import com.qf.pojo.po.Deposit;
import com.qf.pojo.po.LayuiReplay;

import java.util.List;

public interface DepositService {
    /*后台接口*/
    LayuiReplay listAllDepositByPage(String cname, Integer page, Integer limit);

    boolean deleteDepositById(int did);

    Deposit findDepositById(int did);

    boolean updateDeposit(Deposit deposit);

    /*前台接口*/
    List<Deposit> showAllDeposit();
}

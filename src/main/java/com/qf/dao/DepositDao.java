package com.qf.dao;

import com.qf.pojo.po.Deposit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepositDao {
    /*后台接口*/
    List<Deposit> listAllDepositByPage(@Param("cname") String cname, @Param("begin") Integer begin, @Param("limit") Integer limit);

    long getDepositTotalCount(@Param("cname") String cname);

    boolean deleteDepositById(int did);

    Deposit findDepositById(int did);

    boolean updateDeposit(Deposit deposit);

    /*前台接口*/
    List<Deposit> showAllDeposit();

}

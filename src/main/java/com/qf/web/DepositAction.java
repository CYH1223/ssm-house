package com.qf.web;

import com.qf.pojo.po.Deposit;
import com.qf.pojo.po.LayuiReplay;
import com.qf.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepositAction {

    @Autowired
    private DepositService depositService;

    /*后台web++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // 分页查找
    @ResponseBody
    @RequestMapping(value = "/listDeposit", method = RequestMethod.GET)
    public LayuiReplay showAllDeposit (String cname, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer limit) {
        LayuiReplay layuiReplay = depositService.listAllDepositByPage(cname, page, limit);
        return layuiReplay;
    }

    // 删除
    @ResponseBody
    @RequestMapping(value = "/deleteDeposit", method = RequestMethod.POST)
    public LayuiReplay deleteDeposit(int did) {
        LayuiReplay layuiReplay = new LayuiReplay();
        boolean b = depositService.deleteDepositById(did);
        if (!b) {
            layuiReplay.setCode(-1);
        }
        return layuiReplay;
    }

    // 修改之查询信息
    @ResponseBody
    @RequestMapping(value = "/findDeposit")
    public Deposit findDeposit(int did) {
        Deposit deposit = depositService.findDepositById(did);
        return deposit;
    }

    // 修改
    @ResponseBody
    @RequestMapping(value = "/updateDeposit", method = RequestMethod.POST)
    public LayuiReplay updateDeposit(Deposit deposit) {
        LayuiReplay layuiReplay = new LayuiReplay();
        boolean b = depositService.updateDeposit(deposit);
        if (!b) {
            layuiReplay.setCode(-1);
        }
        return layuiReplay;
    }

    /*前台web+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    // 查所有
    @RequestMapping(value = "/shows", method = RequestMethod.GET)
    public String showAllDeposit(Model model) {
        List<Deposit> deposits = depositService.showAllDeposit();
        model.addAttribute("deposit" , deposits);
        return "indexDeposit";
    }

}

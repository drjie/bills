package com.lz.controller;


import com.lz.entity.Bills;
import com.lz.service.billsService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("bills")
@ResponseBody
public class billsController {
    @Autowired
    private billsService billsService;

    @GetMapping("loadAllBills")
    public ResultVO loadAllBills(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, Integer  typeid, Date startDate, Date endDate) {


        return billsService.get(page,limit,typeid,startDate,endDate);
    }
    @PostMapping("addBills")
    public ResultVO addBills(Bills bills,@RequestParam String remark) {
        System.out.println(bills.getBilltime());
        bills.setRemark(remark);
        return billsService.add(bills);
    }
}

package com.lz.controller;


import com.lz.service.billsService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("bills")
public class billsController {
    @Autowired
    private billsService billsService;

    @GetMapping("loadAllBills")
    public ResultVO toLogin(@RequestParam(value = "1") Integer page, @RequestParam(value = "10") Integer limit, Integer  typeid, Date startDate, Date endDate) {


        return billsService.get(page,limit,typeid,startDate,endDate);
    }
}

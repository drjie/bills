package com.lz.controller;


import com.lz.service.BilltypeService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billtype")
public class BilltypeController {
    @Autowired
    private BilltypeService billtypeService;

    @GetMapping("loadAllBillType")
    private ResultVO select(){
        return billtypeService.select();
    }
}

package com.lz.controller;


import com.lz.service.BilltypeService;
import com.lz.vo.ResultVo;
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

    @GetMapping("select")
    private ResultVo select(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                            Integer id){
        return billtypeService.select(pageNum,pageSize,id);
    }
}
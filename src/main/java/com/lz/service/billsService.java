package com.lz.service;

import com.lz.entity.Bills;
import com.lz.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


public interface billsService  {
    ResultVO get(Integer page,Integer limit, Integer  typeid, String startDate1, String endDate1);
    ResultVO add(Bills bills);

}

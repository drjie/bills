package com.lz.service;

import com.lz.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


public interface billsService  {
            ResultVO get(Integer page,Integer limit, Integer  typeid, Date startDate, Date endDate);


}

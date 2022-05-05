package com.lz.service.impl;

import com.lz.dao.BillsMapper;
import com.lz.entity.Bills;
import com.lz.entity.BillsExample;
import com.lz.service.billsService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class billsServiceImpl implements billsService {
   @Autowired
   private BillsMapper billsMapper;
    @Override
    public ResultVO get(Integer page, Integer limit, Integer typeid, Date startDate, Date endDate) {
        ResultVO resultVO=new ResultVO();
        if (typeid ==null&&startDate==null&&endDate==null){
            List<Bills> bills = billsMapper.selectByExample(null);
            resultVO.setCode(200);
            resultVO.setMsg("成功");
            resultVO.setCount(200);

            resultVO.setData(bills);
        }else {
            BillsExample billsExample = new BillsExample();
            BillsExample.Criteria criteria = billsExample.createCriteria();
            criteria.andTypeidEqualTo(typeid);
            criteria.andBilltimeBetween(startDate,endDate);
        }
        return null;
    }
}

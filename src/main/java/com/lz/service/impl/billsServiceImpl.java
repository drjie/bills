package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.BillsMapper;
import com.lz.entity.Bills;
import com.lz.entity.BillsExample;
import com.lz.service.billsService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class billsServiceImpl implements billsService {
   @Autowired
   private BillsMapper billsMapper;
    @Override
    public ResultVO get(Integer page, Integer limit, Integer typeid, Date startDate, Date endDate) {
        ResultVO resultVO=new ResultVO();


        System.out.println(startDate);

        if (typeid ==null&&startDate==null&&endDate==null){
            PageHelper.startPage(page, limit);
            List<Bills> bills = billsMapper.selectByExample(null);
            if (bills!=null&&bills.size()>0){
                resultVO.setCode(200);
                resultVO.setMsg("成功");
                resultVO.setCount((int) billsMapper.countByExample(null));

                resultVO.setData(new PageInfo<Bills>(bills));
            }else {
                resultVO.setCode(400);
                resultVO.setMsg("失败");
                resultVO.setCount(0);

                resultVO.setData(null);
            }

        }else {
            PageHelper.startPage(page, limit);
            BillsExample billsExample = new BillsExample();
            BillsExample.Criteria criteria = billsExample.createCriteria();
            if (typeid!=null){
                criteria.andTypeidEqualTo(typeid);
                if (startDate!=null&&endDate!=null){
                    criteria.andBilltimeBetween(startDate,endDate);
                }
            }else {
                if (startDate!=null&&endDate!=null){
                    criteria.andBilltimeBetween(startDate,endDate);
                }
            }


            List<Bills> users = billsMapper.selectByExample(billsExample);

            if (users!=null&&users.size()>0){
                resultVO.setCode(200);
                resultVO.setMsg("成功");
                resultVO.setCount((int) billsMapper.countByExample(billsExample));

                resultVO.setData(new PageInfo<Bills>(users));
            }else {
                resultVO.setCode(400);
                resultVO.setMsg("失败");
                resultVO.setCount(0);

                resultVO.setData(null);
            }

        }
        return resultVO;
    }

    @Override
    public ResultVO add(Bills bills) {
        int insert = billsMapper.insert(bills);
        ResultVO resultVO=new ResultVO();
        if (insert>0){
            resultVO.setCode(200);
            resultVO.setMsg("录入成功");

        }else {
            resultVO.setCode(-1);
            resultVO.setMsg("录入失败");
        }

        return resultVO;
    }
}

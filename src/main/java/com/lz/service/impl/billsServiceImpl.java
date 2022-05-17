package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.BillsMapper;
import com.lz.dao.BilltypeMapper;
import com.lz.entity.Bills;
import com.lz.entity.BillsExample;
import com.lz.service.billsService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class billsServiceImpl implements billsService {
    @Autowired
    private BillsMapper billsMapper;

    @Override
    public ResultVO get(Integer page, Integer limit, Integer typeid, String startDate1, String endDate1) {
        ResultVO resultVO=new ResultVO();
        List<Bills> bills=new LinkedList<>();

        if (typeid ==null&&startDate1==null&&endDate1==null){
            PageHelper.startPage(page, limit);

           bills= billsMapper.findByType();

            if (bills!=null&&bills.size()>0){
                PageInfo<Bills> billsPageInfo = new PageInfo<>(bills);
                resultVO.setCode(0);
                resultVO.setMsg("成功");
                resultVO.setCount(billsPageInfo.getSize());

                resultVO.setData(bills);
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
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate =null;
            Date endDate = null;

            try {
                startDate = simpleDateFormat.parse(startDate1);
                endDate = simpleDateFormat.parse(endDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }



            bills = billsMapper.selectBytypeidandtime(typeid,startDate,endDate);


            if (bills!=null&&bills.size()>0){
                PageInfo<Bills> billsPageInfo = new PageInfo<>(bills);
                resultVO.setCode(0);
                resultVO.setMsg("成功");
                resultVO.setCount(billsPageInfo.getSize());

                resultVO.setData(bills);
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
        int insert = billsMapper.insertSelective(bills);
        ResultVO resultVO=new ResultVO();
        if (insert>0){
            resultVO.setCode(0);
            resultVO.setMsg("录入成功");

        }else {
            resultVO.setCode(-1);
            resultVO.setMsg("录入失败");
        }

        return resultVO;
    }
}

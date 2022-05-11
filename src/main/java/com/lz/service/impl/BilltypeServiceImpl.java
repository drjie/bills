package com.lz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.dao.BilltypeMapper;
import com.lz.entity.Billtype;
import com.lz.service.BilltypeService;
import com.lz.vo.DataVO;
import com.lz.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BilltypeServiceImpl implements BilltypeService {
    @Autowired
    private BilltypeMapper billtypeMapper;

    @Override
    public ResultVo select(Integer pageNum, Integer pageSize, Integer id) {
        ResultVo resultVo = new ResultVo();

        //data对应的结果
        List<Billtype> billtypes;

        DataVO<Billtype> dataVO;


        //说明传递了id，那就是findById
        if(id !=null){
            billtypes = new ArrayList<>();

            Billtype billtype=billtypeMapper.selectByPrimaryKey(id);

            //没有查到用户的情况
            if(billtype == null){
                dataVO = new DataVO<>(0L,billtypes,pageNum,pageSize);

                resultVo = new ResultVo(4000,"没有这条记账类型！！！",false,dataVO);
            }else {
                //查到了放到集合里
                billtypes.add(billtype);

                dataVO = new DataVO<>(1L, billtypes, pageNum, pageSize);

                resultVo = new ResultVo(1000, "查询此类型成功！", true, dataVO);
            }
        }else {
            //开启分页
            PageHelper.startPage(pageNum,pageSize);

            billtypes = billtypeMapper.selectByExample(null);

            if(billtypes.size()==0){
                dataVO = new DataVO<>(0L,billtypes,pageNum,pageSize);

                resultVo = new ResultVo(4100,"没有记账类型！",false,dataVO);
            }else{
                //封装pageInfo，为了获取总数据量
                PageInfo<Billtype> pageInfo = new PageInfo<>(billtypes);

                dataVO = new DataVO<>(pageInfo.getTotal(),billtypes,pageNum,pageSize);

                resultVo = new ResultVo(1100,"记账类型查询成功！",true,dataVO);
            }
        }

        return resultVo;
    }
}

package com.lz.service.impl;

import com.lz.dao.BilltypeMapper;
import com.lz.entity.Billtype;
import com.lz.service.BilltypeService;
import com.lz.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BilltypeServiceImpl implements BilltypeService {
    @Autowired
    private BilltypeMapper billtypeMapper;

    @Override
    public ResultVO select() {
        ResultVO resultVo = new ResultVO();

        List<Billtype> billtypes = billtypeMapper.selectByExample(null);

        if (billtypes!=null&&billtypes.size()>0){
            resultVo.setCode(0);
            resultVo.setMsg("");
            resultVo.setCount(0);
            resultVo.setData(billtypes);
        }
        return resultVo;
    }
}

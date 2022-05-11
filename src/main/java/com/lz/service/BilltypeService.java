package com.lz.service;

import com.lz.vo.ResultVo;

public interface BilltypeService {
    ResultVo select(Integer pageNum, Integer pageSize, Integer id);
}

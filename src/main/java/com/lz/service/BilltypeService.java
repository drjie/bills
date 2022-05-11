package com.lz.service;

import com.lz.vo.ResultVO;

public interface BilltypeService {
    ResultVO select(Integer pageNum, Integer pageSize, Integer id);
}

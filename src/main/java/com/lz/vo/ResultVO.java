package com.lz.vo;

import com.github.pagehelper.PageInfo;
import com.lz.entity.Bills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private Integer code;
    private String msg;
    private Integer count;
    private PageInfo<Bills> data;



}

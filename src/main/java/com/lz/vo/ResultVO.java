package com.lz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    //业务响应码
    private Integer code;
    //业务消息
    private String msg;
    private Boolean success;
    private Object data;
    private Integer count;
}

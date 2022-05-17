package com.lz.dao;

import com.lz.entity.Bills;
import com.lz.entity.Billtype;
import com.lz.entity.BilltypeExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BilltypeMapper {
    long countByExample(BilltypeExample example);

    int deleteByExample(BilltypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Billtype record);

    int insertSelective(Billtype record);

    List<Billtype> selectByExample(BilltypeExample example);

    Billtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Billtype record, @Param("example") BilltypeExample example);

    int updateByExample(@Param("record") Billtype record, @Param("example") BilltypeExample example);

    int updateByPrimaryKeySelective(Billtype record);

    int updateByPrimaryKey(Billtype record);


}
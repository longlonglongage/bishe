package com.ming.hospital.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ming.hospital.pojo.Appointment;
import com.ming.hospital.pojo.Dept;
import com.ming.hospital.pojo.DeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper extends BaseMapper<Dept> {
    int countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(Long deid);

    int iinsert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(Long deid);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> findHospitalList();
}
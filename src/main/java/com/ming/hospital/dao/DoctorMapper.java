package com.ming.hospital.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.pojo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Long did);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Long did);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    List<Doctor> selectToPage(DoctorPage doctorPage);

    Integer selectToPageTotalCount(DoctorPage doctorPage);

    Doctor selectById(Long id);

    List <Doctor> getListByTop4();

    /**
     * 分页查询医生
     *
     * @param dname 医院名
     * @return 页面结果
     */
    Page<Doctor> selectByPage(@Param( "dname" ) String dname);
}
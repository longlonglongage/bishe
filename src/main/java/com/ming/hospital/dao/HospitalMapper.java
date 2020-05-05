package com.ming.hospital.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ming.hospital.dto.HospitalPage;
import com.ming.hospital.pojo.Hospital;
import com.ming.hospital.pojo.HospitalExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HospitalMapper  {
    int countByExample(HospitalExample example);

    int deleteByExample(HospitalExample example);

    int deleteByPrimaryKey(Long hid);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    List<Hospital> selectByExample(HospitalExample example);

    Hospital selectByPrimaryKey(Long hid);

    int updateByExampleSelective(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByExample(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);

    List<Hospital> selectToPage(HospitalPage hospitalPage);

    Integer selectToPageTotalCount(HospitalPage hospitalPage);

    List<Hospital> getListByTop3();

    /**
     * 分页查询医院
     *
     * @param hname 医院名
     * @return 页面结果
     */
    Page<Hospital> selectByPage(@Param( "hname" ) String hname);

    void edit(Hospital hospital);

    Integer addHospital(Hospital hospital);
}
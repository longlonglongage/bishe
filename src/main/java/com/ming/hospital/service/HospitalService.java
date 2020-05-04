package com.ming.hospital.service;

import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.dto.HospitalPage;
import com.ming.hospital.model.PageResult;
import com.ming.hospital.model.QueryPageBean;
import com.ming.hospital.pojo.Doctor;
import com.ming.hospital.pojo.Hospital;
import com.ming.hospital.pojo.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ming on 2017/11/17.
 */
public interface HospitalService {

    Page getPageData(Integer times,Integer insurance,String name ,Integer grade,Integer pageNum,Integer pageSize);

    Integer totalCount();

    Integer selectToPageTotalCount(HospitalPage hospitalPage);

    Hospital getHospitalById(Long hid);

    List<Hospital> getList();

    List<Hospital> getListByTop3();

    Integer addHospital(Hospital hospital);

    Boolean del(Integer id);

    Boolean edit(Hospital hospital);

    /**
     * 分页查询
     *
     * @param queryPageBean 分页条件封装类
     * @return 分页结果
     */
    PageResult pageQuery(QueryPageBean queryPageBean);
}

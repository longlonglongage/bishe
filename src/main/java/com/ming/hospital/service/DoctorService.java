package com.ming.hospital.service;

import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.model.PageResult;
import com.ming.hospital.model.QueryPageBean;
import com.ming.hospital.pojo.Doctor;
import com.ming.hospital.pojo.Hospital;
import com.ming.hospital.pojo.Page;
import com.ming.hospital.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ming on 2017/11/17.
 */
public interface DoctorService {

    List<Doctor> getListByGrade(Integer grade);

    List<Doctor> getListByDept(Long dept);

    List<Doctor> getList();

    Page<Doctor> selectToPage(DoctorPage doctorPage);

    Doctor  selectById(Long id);

    List<Doctor> getListByTop4();

    Integer addDoctor(Doctor doctor);

    Boolean del(Long id);

    Boolean edit(Doctor doctor);

    Doctor findDoctorById(Long hid);
    /**
     * 分页查询
     *
     * @param queryPageBean 分页条件封装类
     * @return 分页结果
     */
    PageResult pageQuery(QueryPageBean queryPageBean);

}

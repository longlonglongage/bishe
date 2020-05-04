package com.ming.hospital.service;

import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.pojo.Doctor;
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

    Boolean del(Integer id);

    Boolean edit(Doctor doctor);
}

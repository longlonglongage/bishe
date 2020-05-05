package com.ming.hospital.service.impl;

import com.github.pagehelper.PageHelper;
import com.ming.hospital.dao.DoctorMapper;
import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.model.PageResult;
import com.ming.hospital.model.QueryPageBean;
import com.ming.hospital.pojo.Doctor;
import com.ming.hospital.pojo.DoctorExample;
import com.ming.hospital.pojo.Hospital;
import com.ming.hospital.pojo.Page;
import com.ming.hospital.service.DoctorService;
import net.bytebuddy.matcher.BooleanMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ming on 2017/11/17.
 */
@Service
public class DoctorServiceImpl implements DoctorService  {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> getListByGrade(Integer grade) {
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andGradeEqualTo(grade);
        return doctorMapper.selectByExample(doctorExample);
    }

    @Override
    public List<Doctor> getListByDept(Long did) {
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andDeidEqualTo(did);
        return null;
    }

    @Override
    public List<Doctor> getList() {
        return doctorMapper.selectByExample(new DoctorExample());
    }

    @Override
    public Page<Doctor> selectToPage(DoctorPage doctorPage) {
        Page <Doctor> page = new Page<>();
        Integer pageNum = doctorPage.getPageNum();
        doctorPage.setPageNum((pageNum - 1) * doctorPage.getPageSize());
        List<Doctor>  list = doctorMapper.selectToPage(doctorPage);

        page.setData(list);
        page.setPageNum(pageNum);
        page.setPageSize(doctorPage.getPageSize());
        Integer totalCount = doctorMapper.selectToPageTotalCount(doctorPage);
        page.setTotalCount(totalCount);
        page.setTotalPage((int)Math.ceil( totalCount*1.0/page.getPageSize() ));

        return page;
    }

    @Override
    public Doctor selectById(Long id) {
        return  doctorMapper.selectById(id);
    }

    @Override
    public List<Doctor> getListByTop4() {
        return  doctorMapper.getListByTop4();
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        Integer insert = doctorMapper.insert(doctor);
        return insert;
    }

    @Override
    public Boolean del(Long id) {
        Integer i = doctorMapper.deleteByPrimaryKey(id);
        if (i!=0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean edit(Doctor doctor) {
        String id = "a";
        Boolean flag =false;
        Integer integer = doctorMapper.updateByPrimaryKeySelective(doctor);
        if (integer!=0){
            flag = true;
        }
        return flag;
    }

    @Override
    public Doctor findDoctorById(Long hid) {

        return doctorMapper.selectByPrimaryKey(hid);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        //使用 PageHelper 完成分页查询
        com.github.pagehelper.Page<Doctor> page = PageHelper.startPage(
                queryPageBean.getCurrentPage(), queryPageBean.getPageSize() ).
                doSelectPage( () -> doctorMapper.selectByPage( queryPageBean.getQueryString() ) );
        return PageResult.builder()
                //返回总条数
                .total( page.getTotal() )
                //返回分页数据集合
                .rows( page.getResult() ).build();
    }
}

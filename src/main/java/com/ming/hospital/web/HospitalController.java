package com.ming.hospital.web;

import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.model.PageResult;
import com.ming.hospital.model.QueryPageBean;
import com.ming.hospital.model.Result;
import com.ming.hospital.pojo.Dept;
import com.ming.hospital.pojo.Doctor;
import com.ming.hospital.pojo.Hospital;
import com.ming.hospital.pojo.Page;
import com.ming.hospital.service.DeptService;
import com.ming.hospital.service.DoctorService;
import com.ming.hospital.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ming on 2017/11/18.
 */
@Slf4j
@Api(value = "医院信息Controller", tags = "医院信息相关接口")
@Controller
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private DoctorService doctorService;


    @RequestMapping("/hospitalList")
    @ApiOperation(value = "根据条件分页查询医院数据")
    public String hospitalList(@RequestParam(required = false) @ApiParam(value = "提供服务次数") Integer times,
                               @RequestParam(required = false) @ApiParam(value = "医保") Integer insurance,
                               @RequestParam(required = false) @ApiParam(value = "名称") String name,
                               @RequestParam(required = false) @ApiParam(value = "1三甲医院 2三乙医院 3二甲医院 4二级医院") Integer grade,
                               @RequestParam(required = false) @ApiParam(value = "当前页数") Integer pageNum,
                               Model model) {
        Integer pageSize = 4;
        if (pageNum == null) {
            pageNum = 1;
        }
        Page<Hospital> pageData = hospitalService.getPageData( times, insurance, name, grade, pageNum, pageSize );
        model.addAttribute( "page", pageData );
        model.addAttribute( "grade", grade );
        model.addAttribute( "name", name );
        model.addAttribute( "times", times );
        model.addAttribute( "insurance", insurance );

        return "hospital_list";
    }

    @RequestMapping("/detail/{hid}")
    @ApiOperation(value = "根据id查询医院数据")
    public String detail(DoctorPage doctorPage, @ApiParam(value = "id") @PathVariable Long hid, Model model) {
        doctorPage.setHid( hid );
        Hospital hospital = hospitalService.getHospitalById( hid );
        //两个科室
        List<Dept> deptList1 = deptService.getListByGrade( 1 );
        List<Dept> deptList2 = deptService.getListByGrade( 2 );

        //放PageBean
        Page<Doctor> page = doctorService.selectToPage( doctorPage );

        model.addAttribute( "page", page );
        model.addAttribute( "hid", hid );
        model.addAttribute( "hospital", hospital );
        model.addAttribute( "grade", doctorPage.getGrade() );
        model.addAttribute( "deid", doctorPage.getDeid() );
        model.addAttribute( "deptList1", deptList1 );
        model.addAttribute( "deptList2", deptList2 );

        return "hospital_detail";
    }

    @RequestMapping("/detaildemo/{hid}")
    @ApiOperation(value = "医院简介")
    public String detaildemo(DoctorPage doctorPage, @PathVariable Long hid, Model model) {
        doctorPage.setHid( hid );
        Hospital hospital = hospitalService.getHospitalById( hid );
        //两个科室
        List<Dept> deptList1 = deptService.getListByGrade( 1 );
        List<Dept> deptList2 = deptService.getListByGrade( 2 );

        //放PageBean
        Page<Doctor> page = doctorService.selectToPage( doctorPage );

        model.addAttribute( "page", page );
        model.addAttribute( "hid", hid );
        model.addAttribute( "hospital", hospital );
        model.addAttribute( "grade", doctorPage.getGrade() );
        model.addAttribute( "deid", doctorPage.getDeid() );
        model.addAttribute( "deptList1", deptList1 );
        model.addAttribute( "deptList2", deptList2 );

        return "C_hospital_detail";
    }

    @RequestMapping("/guahaoguizhe/{hid}")
    @ApiOperation(value = "挂号规则")
    public String guahaoguizhe(DoctorPage doctorPage, @PathVariable Long hid, Model model) {
        doctorPage.setHid( hid );
        Hospital hospital = hospitalService.getHospitalById( hid );
        //两个科室
        List<Dept> deptList1 = deptService.getListByGrade( 1 );
        List<Dept> deptList2 = deptService.getListByGrade( 2 );

        //放PageBean
        Page<Doctor> page = doctorService.selectToPage( doctorPage );

        model.addAttribute( "page", page );
        model.addAttribute( "hid", hid );
        model.addAttribute( "hospital", hospital );
        model.addAttribute( "grade", doctorPage.getGrade() );
        model.addAttribute( "deid", doctorPage.getDeid() );
        model.addAttribute( "deptList1", deptList1 );
        model.addAttribute( "deptList2", deptList2 );

        return "guahaoguizhe";
    }

    @RequestMapping("/findPage")
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageResult selectByPage(@RequestBody QueryPageBean queryPageBean) {
        return hospitalService.pageQuery( queryPageBean );
    }

    @RequestMapping("/addhospital")
    @ResponseBody
    @ApiOperation(value = "添加医院")
    public Result add(@RequestBody Hospital hospital) {
        hospitalService.addHospital( hospital );
        return Result.ok( "添加医院成功" );
    }

    //编辑数据
    @RequestMapping("edit")
    @ResponseBody
    @ApiOperation(value = "编辑数据")
    public Result<Object> edit(@RequestParam(required = true) Hospital hospital) {
        hospitalService.edit( hospital );
        return Result.ok( "编辑数据成功" );
    }

    @RequestMapping("/delhospital/{hid}")
    @ResponseBody
    @ApiOperation(value = "删除数据")
    public Result<Object> del(@PathVariable("hid") Long hid) {
        hospitalService.del(hid);
        return Result.ok( "删除数据成功" );
    }

    @RequestMapping("/findHospitalById/{hid}")
    @ResponseBody
    @ApiOperation(value = "根据id查询单条记录")
    public Result<Object> findHospitalById(@PathVariable("hid") Long hid) {
        Hospital hospitalById = hospitalService.findHospitalById(hid);
        return Result.ok( hospitalById,"查询数据成功" );
    }


}
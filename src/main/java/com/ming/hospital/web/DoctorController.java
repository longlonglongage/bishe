package com.ming.hospital.web;

import com.ming.hospital.dto.DoctorPage;
import com.ming.hospital.model.PageResult;
import com.ming.hospital.model.QueryPageBean;
import com.ming.hospital.model.Result;
import com.ming.hospital.pojo.*;
import com.ming.hospital.service.DeptService;
import com.ming.hospital.service.DoctorService;
import com.ming.hospital.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ming on 2017/11/19.
 */
@Slf4j
@Api(value = "医生信息Controller", tags = "医生信息相关接口")
@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DeptService deptService;



    @RequestMapping("/doctorList")
    public String doctorList(DoctorPage doctorPage,Model model){
        //一级和二级科室
        List<Dept> deptList1 = deptService.getListByGrade(1);
        List<Dept> deptList2 = deptService.getListByGrade(2);
        //1主任医师 2副主任医师 3主治医师 4普通医师
        //科室id，医生等级,//医生姓名

        Page<Doctor> page = doctorService.selectToPage(doctorPage);

        model.addAttribute("deptList1",deptList1);
        model.addAttribute("deptList2",deptList2);
        model.addAttribute("page",page);

        model.addAttribute("grade",doctorPage.getGrade());
        model.addAttribute("key",doctorPage.getKey());
        model.addAttribute("deid",doctorPage.getDeid());

        return "doctor_list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable Long id , Model model){
        Doctor doctor = doctorService.selectById(id);
        String[] times = doctor.getSurgeryweek().split(","); //就诊时间
        List<DayInfo> dayInfoList = new ArrayList<>();
        Date date = new Date();

        for(int i = 0; i < 7; i++){
            DayInfo dayInfo = new DayInfo();
            dayInfo.setDate(DateUtils.getDate(date));
            dayInfo.setFullDate(DateUtils.getFillDate(date));
            dayInfo.setWeek(DateUtils.getWeek(date));
            for (String  time : times) {
                if(dayInfo.getWeek() .equals(time.substring(0,3)) ){
                    time = time.substring(3); //取上午、下午、晚上
                    if(time.equals("上午")){
                        dayInfo.setSw(1);
                    }else if(time.equals("下午")){
                        dayInfo.setXw(1);
                    }else{
                        dayInfo.setWs(1);
                    }
                }
            }
            dayInfoList.add(dayInfo);
            date.setTime(date.getTime() + 1000*60*60*24);
        }
        model.addAttribute("doctor",doctor);
        model.addAttribute("dayInfoList",dayInfoList);

        return "doctor_detail";
    }

    @RequestMapping("/addDoctor")
    public ModelAndView addDoctor(@PathVariable Long id , Model model){
        Doctor doctor = doctorService.selectById(id);
        String[] times = doctor.getSurgeryweek().split(","); //就诊时间
        List<DayInfo> dayInfoList = new ArrayList<>();
        Date date = new Date();

        for(int i = 0; i < 7; i++){
            DayInfo dayInfo = new DayInfo();
            dayInfo.setDate(DateUtils.getDate(date));
            dayInfo.setFullDate(DateUtils.getFillDate(date));
            dayInfo.setWeek(DateUtils.getWeek(date));
            for (String  time : times) {
                if(dayInfo.getWeek() .equals(time.substring(0,3)) ){
                    time = time.substring(3); //取上午、下午、晚上
                    if(time.equals("上午")){
                        dayInfo.setSw(1);
                    }else if(time.equals("下午")){
                        dayInfo.setXw(1);
                    }else{
                        dayInfo.setWs(1);
                    }
                }
            }
            dayInfoList.add(dayInfo);
            date.setTime(date.getTime() + 1000*60*60*24);
        }
        model.addAttribute("doctor",doctor);
        model.addAttribute("dayInfoList",dayInfoList);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    // 添加数据
    @ResponseBody
    @RequestMapping("/adddoctor")
    @ApiOperation(value = "添加医生")
    public Result add(@RequestBody Doctor doctor) {
        Integer integer = doctorService.addDoctor(doctor);
        return Result.ok("添加数据成功");
    }

    //编辑数据
    @ResponseBody
    @RequestMapping("edit")
    @ApiOperation(value = "编辑数据")
    public Result edit(@RequestParam(required = true) Doctor doctor) {
        doctorService.edit(doctor);
        return Result.ok("编辑数据成功");
    }


    //删除数据
    @RequestMapping("/deldoctor/{id}")
    @ResponseBody
    @ApiOperation(value = "删除数据")
    public Result<Object> del(@PathVariable("id") Long id) {
        doctorService.del(id);
        return Result.ok( "删除数据成功" );
    }

    //查看详情
    @RequestMapping("/findDoctorById/{hid}")
    @ResponseBody
    @ApiOperation(value = "根据id查询单条记录")
    public Result<Object> findDoctorById(@PathVariable("hid") Long hid) {
        Doctor doctorById = doctorService.findDoctorById(hid);
        return Result.ok( doctorById,"查询数据成功" );
    }

    @RequestMapping("/findPage")
    @ResponseBody
    @ApiOperation(value = "分页查询")
    public PageResult selectByPage(@RequestBody QueryPageBean queryPageBean) {
        return doctorService.pageQuery( queryPageBean );
    }

}

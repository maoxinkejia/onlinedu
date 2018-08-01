package edu.zhangmeng.onlinedu.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.zhangmeng.onlinedu.bean.EduTeacher;
import edu.zhangmeng.onlinedu.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeacherController {

    @Reference
    private TeacherService teacherService;

    //查询所有教师列表，或根据条件查询教师列表
    @RequestMapping("toTeacher.html")
    public String teacher(Model model, HttpServletRequest request) {
        //获取表单参数
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        String createTime = request.getParameter("createTime");
        String updateTime = request.getParameter("updateTime");
        System.out.println(createTime);
        List<EduTeacher> eduTeacherList = null;
        EduTeacher eduTeacher = new EduTeacher();

        if (createTime != null && createTime.length()>0) {
            eduTeacher.setDate1(createTime);
        }
        if (updateTime != null && updateTime.length()>0) {
            eduTeacher.setDate2(updateTime);
        }
        if (name != null && name.length()>0) {
            eduTeacher.setName(name);
        }
        if (status != null && status.length()>0) {
            eduTeacher.setStatus(Integer.parseInt(status));
        }

        if (eduTeacher != null) {
            eduTeacherList = teacherService.queryByKeyword(eduTeacher);
        } else {
            eduTeacherList = teacherService.queryAllTeachers();
        }

        model.addAttribute("teacherList", eduTeacherList);
        return "teacher";
    }

    //去往添加教师页面
    @RequestMapping("addTeacher")
    public String addTeacher() {
        return "addTeacher";
    }

    //根据id删除教师
    @RequestMapping("delTeacher")
    public String delTeacher(HttpServletRequest request) {
        String id = request.getParameter("id");
        teacherService.deleteTeacher(id);
        return "redirect://manage.edu.com/toTeacher.html";
    }

}

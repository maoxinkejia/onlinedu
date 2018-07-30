package edu.zhangmeng.onlinedu.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import edu.zhangmeng.onlinedu.bean.EduTeacher;
import edu.zhangmeng.onlinedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {

    @Reference
    private TeacherService teacherService;

    //去往教师列表页面
    @RequestMapping("toTeacher.html")
    public String teacher(Model model) {
        List<EduTeacher> teacherList = teacherService.queryAllTeachers();
        model.addAttribute("teacherList", teacherList);
        return "teacher";
    }
}

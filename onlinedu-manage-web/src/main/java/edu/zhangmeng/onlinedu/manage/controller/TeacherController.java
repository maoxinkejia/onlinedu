package edu.zhangmeng.onlinedu.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
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
        String isStar = request.getParameter("isStar");
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
        if (isStar != null && isStar.length()>0) {
            eduTeacher.setIsStar(Integer.parseInt(isStar));
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
    @RequestMapping("toAddTeacher")
    public String toAddTeacher() {
        return "addTeacher";
    }

    //根据id删除教师
    @RequestMapping("delTeacher")
    public String delTeacher(HttpServletRequest request) {
        String id = request.getParameter("id");
        teacherService.deleteTeacher(id);
        return "redirect://manage.edu.com/toTeacher.html";
    }


    @RequestMapping("addTeacher")
    public String addTeacher(HttpServletRequest request) {
        //name education subjectId isStar sort career
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String education = request.getParameter("education");
        String subjectId = request.getParameter("subjectId");
        String isStar = request.getParameter("isStar");
        String sort = request.getParameter("sort");
        String career = request.getParameter("career");

        EduTeacher eduTeacher = new EduTeacher();

        if (name != null && name.length() > 0) {
            eduTeacher.setName(name);
        }
        if (education != null && education.length() > 0) {
            eduTeacher.setEducation(education);
        }
        if (subjectId != null && subjectId.length() > 0) {
            eduTeacher.setSubjectId(Integer.parseInt(subjectId));
        }
        if (isStar != null && isStar.length() > 0) {
            eduTeacher.setIsStar(Integer.parseInt(isStar));
        }
        if (sort != null && sort.length() > 0) {
            eduTeacher.setSort(Integer.parseInt(sort));
        }
        if (career != null && career.length() > 0) {
            eduTeacher.setCareer(career);
        }

        if (id != null) {
            eduTeacher.setId(Integer.parseInt(id));
            teacherService.editTeacher(eduTeacher);
        } else {
            teacherService.saveTeacher(eduTeacher);
        }
        return "redirect://manage.edu.com/toTeacher.html";
    }

    //去往修改教师页面
    @RequestMapping("/toEditTeacher")
    public String toEditTeacher(HttpServletRequest request,Model model) {
        String id = request.getParameter("id");
        EduTeacher eduTeacher = teacherService.queryById(id);
        model.addAttribute("eduTeacher", eduTeacher);
        return "editTeacher";
    }


}

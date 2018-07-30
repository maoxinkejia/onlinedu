package edu.zhangmeng.onlinedu.service;

import edu.zhangmeng.onlinedu.bean.EduTeacher;

import java.util.List;

public interface TeacherService {

    //查询所有教师集合
    List<EduTeacher> queryAllTeachers();
}

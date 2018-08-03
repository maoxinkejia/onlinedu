package edu.zhangmeng.onlinedu.service;

import edu.zhangmeng.onlinedu.bean.EduTeacher;

import java.util.List;

public interface TeacherService {

    //查询所有教师集合
    List<EduTeacher> queryAllTeachers();

    //根据条件查询教师
    List<EduTeacher> queryByKeyword(EduTeacher eduTeacher);

    //删除教师
    void deleteTeacher(String id);

    //添加教师
    void saveTeacher(EduTeacher eduTeacher);

    //根据主键查询教师信息用来修改
    EduTeacher queryById(String id);

    //修改教师
    void editTeacher(EduTeacher eduTeacher);
}

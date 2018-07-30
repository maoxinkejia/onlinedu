package edu.zhangmeng.onlinedu.manage.mapper;

import edu.zhangmeng.onlinedu.bean.EduTeacher;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EduTeacherMapper extends Mapper<EduTeacher>{
    //查询所有教师，并根据sort排序
    List<EduTeacher> selectAllOrderBySort();
}

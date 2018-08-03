package edu.zhangmeng.onlinedu.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import edu.zhangmeng.onlinedu.bean.EduTeacher;
import edu.zhangmeng.onlinedu.manage.mapper.EduTeacherMapper;
import edu.zhangmeng.onlinedu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private EduTeacherMapper eduTeacherMapper;

    @Override
    public List<EduTeacher> queryAllTeachers() {
        return eduTeacherMapper.selectAllOrderBySort();
    }

    @Override
    public List<EduTeacher> queryByKeyword(EduTeacher eduTeacher) {
        return eduTeacherMapper.selectByKeyword(eduTeacher);
    }

    @Override
    public void deleteTeacher(String id) {
        Example example = new Example(EduTeacher.class);
        example.createCriteria().andEqualTo("id", id);
        eduTeacherMapper.deleteByExample(example);
    }

    @Override
    public void saveTeacher(EduTeacher eduTeacher) {
        eduTeacher.setCreateTime(new Date());
        eduTeacherMapper.insertSelective(eduTeacher);
    }

    @Override
    public EduTeacher queryById(String id) {
        return eduTeacherMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public void editTeacher(EduTeacher eduTeacher) {
        eduTeacher.setUpdateTime(new Date());
        eduTeacherMapper.updateByPrimaryKeySelective(eduTeacher);
    }

}

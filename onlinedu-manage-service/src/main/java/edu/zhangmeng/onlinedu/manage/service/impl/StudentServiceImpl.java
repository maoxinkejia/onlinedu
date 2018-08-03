package edu.zhangmeng.onlinedu.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import edu.zhangmeng.onlinedu.bean.EduUser;
import edu.zhangmeng.onlinedu.manage.mapper.EduUserMapper;
import edu.zhangmeng.onlinedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EduUserMapper eduUserMapper;


    @Override
    public List<EduUser> getAllUser(Map<String, Object> paramMap) {
        //拿到参数和状态
        String email = (String) paramMap.get("email");
        String mobile = (String) paramMap.get("mobile");
        String name = (String) paramMap.get("name");
        String status = (String) paramMap.get("status");

        Example example = new Example(EduUser.class);

        if (email != null && email.length() > 0) {
            example.createCriteria().andLike("email", email);
        }
        if (mobile != null && mobile.length() > 0) {
            example.createCriteria().andLike("mobile", mobile);
        }
        if (name != null && name.length() > 0) {
            example.createCriteria().andLike("showName", name);
        }

        return eduUserMapper.selectByExample(example);
    }

    @Override
    public void changeStatus(Integer userId) {
        //
        EduUser eduUser = new EduUser();
        eduUser.setUserId(userId);
        //根据用户id查询一个用户对象出来
        EduUser user = eduUserMapper.selectOne(eduUser);
        //拿到用户的账号状态
        Integer isAvalible = user.getIsAvalible();
        if (isAvalible == 1) {
            user.setIsAvalible(2);
        } else {
            user.setIsAvalible(1);
        }

        eduUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updPwdByUserId(String userId, String pwd2) {
        EduUser eduUser = new EduUser();
        eduUser.setUserId(Integer.parseInt(userId));
        eduUser.setPassword(pwd2);
        eduUserMapper.updateByPrimaryKeySelective(eduUser);
    }
}

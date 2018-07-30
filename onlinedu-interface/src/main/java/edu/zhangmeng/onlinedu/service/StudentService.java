package edu.zhangmeng.onlinedu.service;


import edu.zhangmeng.onlinedu.bean.EduUser;

import java.util.List;
import java.util.Map;

public interface StudentService {

    //根据关键字查询所有用户信息（如果没有参数则查询所有）
    List<EduUser> getAllUser(Map<String, Object> paramMap);

    //根据用户id更改账户状态（冻结/解冻）
    void changeStatus(Integer userId);

    //根据用户id更改用户密码
    void updPwdByUserId(String userId, String pwd2);
}

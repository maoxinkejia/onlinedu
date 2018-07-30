package edu.zhangmeng.onlinedu.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import edu.zhangmeng.onlinedu.bean.EduUser;
import edu.zhangmeng.onlinedu.common.controller.BaseController;
import edu.zhangmeng.onlinedu.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController extends BaseController {

    @Reference
    private StudentService studentService;

    //去学生列表页面
    @RequestMapping("student.html")
    public String student() {
        return "student";
    }

    //查询所有学生
    @ResponseBody
    @RequestMapping(value = "/queryStudents", method = RequestMethod.POST)
    public Object queryAllStudents(@RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "status", required = false) Integer status,
                                   Model model) {
        start();
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            if (keyword != null && keyword.length() > 0) {
                if (keyword.contains("@")) {
                    paramMap.put("email", keyword);
                }
                if (keyword.length() == 11) {
                    paramMap.put("mobile", keyword);
                }
                paramMap.put("name", keyword);
            }
            if (status != null) {
                paramMap.put("status", status);
            }

            List<EduUser> userList = studentService.getAllUser(paramMap);
            model.addAttribute("userList", userList);
            data(userList);
            success(true);
        } catch (Exception e) {
            success(false);
            e.printStackTrace();
        }
        return end();
    }

    //更改用户状态（冻结/解冻）
    @ResponseBody
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public Object changeStatus(@RequestParam(value = "id", required = true) Integer userId) {
        start();
        try {
            studentService.changeStatus(userId);
            success(true);
        } catch (Exception e) {
            success(false);
            e.printStackTrace();
        }
        return end();
    }

    //跳转到修改密码页面
    @RequestMapping("/toEditPwd")
    public String editPwd(HttpServletRequest request, Model model) {
        //将userId传到修改页面
        String userId = request.getParameter("userId");
        model.addAttribute("userId", userId);
        return "editPwd";
    }

    //修改密码
    @ResponseBody
    @RequestMapping(value = "/updPwd", method = RequestMethod.POST)
    public Object updPwd(@RequestParam(value = "pwd2") String pwd2,
                         @RequestParam(value = "userId") String userId) {

        start();
        try {
            studentService.updPwdByUserId(userId, pwd2);
            success(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return end();
    }

}

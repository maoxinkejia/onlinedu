package edu.zhangmeng.onlinedu.bean;

import java.io.Serializable;

public class EduCourseTeacher implements Serializable {
    private Integer courseId;

    private Integer teacherId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
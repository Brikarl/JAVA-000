package entity;

import java.util.List;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 17:29
 * @Version 1.0
 */
public class Course {
    private String courseName;
    private Integer courseId;

    public Course() {

    }

    public Course(String courseName, Integer courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}



package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 22:33
 * @Version 1.0
 */
@RestController
public class WebController {
    private Student student;
    private Course course;

    @GetMapping("/set_course")
    public String setCourse(@RequestParam String courseName, @RequestParam Integer courseId) {
        course.setCourseName(courseName);
        course.setCourseId(courseId);
        return course.toString();
    }

    @GetMapping("/set_student")
    public String setStudent(@RequestParam String name, @RequestParam Integer age, @RequestParam Course course) {
        student.setAge(age);
        student.setName(name);
        return student.toString();
    }
}

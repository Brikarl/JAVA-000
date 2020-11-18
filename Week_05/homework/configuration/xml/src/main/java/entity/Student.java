package entity;

/**
 * @Author: Yunkai Bo
 * @Date: 2020/11/18 17:27
 * @Version 1.0
 */
public class Student {
    private String name;
    private Integer age;
    private Course course;

    public Student(String name, Integer age, Course course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Student() {
        System.out.println(this.toString() + " setter 注入成功。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void hasClass() {
        System.out.println(this.getName() + " has " + course.getCourseName());
    }
}

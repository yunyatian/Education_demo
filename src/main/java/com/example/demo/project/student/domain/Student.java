package com.example.demo.project.student.domain;

import com.example.demo.project.teacher.domain.Teacher;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
public class Student {
    private Integer stuId;
    private String name;
    private String sex;
    private Integer age;
    private Instant entryTime;
    private List<String> teachers;
    private List<StudentProperties> properties;

    public Student PerfectInformation(String teacher, StudentProperties properties){
        List<StudentProperties> studentProperties = new LinkedList<>();
        if (this.properties != null) {
            studentProperties.addAll(this.properties);
        }
        List<String> teachers = new LinkedList<>();
        if (this.teachers == null){
            teachers.add(teacher);
        }else if (!this.teachers.contains(teacher)) {
            teachers.addAll(this.teachers);
            teachers.add(teacher);
        }else{
            teachers.addAll(this.teachers);
        }
        studentProperties.add(properties);
        this.properties = studentProperties;
        this.teachers = teachers;
        return this;
    }
}

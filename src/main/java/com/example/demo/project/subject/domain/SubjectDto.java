package com.example.demo.project.subject.domain;

import com.example.demo.project.teacher.domain.TeacherFaculty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SubjectDto {
    private Integer subId;
    private String name;
    private List<TeacherFaculty> teachers;
}

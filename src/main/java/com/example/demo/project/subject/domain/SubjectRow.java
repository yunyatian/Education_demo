package com.example.demo.project.subject.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.project.teacher.domain.TeacherFaculty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@TableName(value = "subject")
@Data
@Builder
public class SubjectRow {
    private Integer subId;
    private String name;
}

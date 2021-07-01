package com.example.demo.project.teacher.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@TableName(value = "teachers")
@Data
@Builder
public class Teacher {
    private String jobId;
    private String name;
    private String sex;
    private Integer age;
    private String subject;
    private Instant entryTime;
}

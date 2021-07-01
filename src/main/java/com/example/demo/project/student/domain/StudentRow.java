package com.example.demo.project.student.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@TableName(value = "students")
@Data
@Builder
public class StudentRow {
    private Integer stuId;
    private String name;
    private String sex;
    private Integer age;
    private Instant entryTime;
    private String teachers;
    private String properties;

}

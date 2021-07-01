package com.example.demo.project.student.domain;


import lombok.*;


@Data
@AllArgsConstructor
//添加无参构造使得jackson序列化可以对应参数
@NoArgsConstructor
public class StudentProperties {
    private Integer teacherId;
    private String teacher;
    private Integer subjectId;
    private String subject;
    private Integer score;
    private String period;

}

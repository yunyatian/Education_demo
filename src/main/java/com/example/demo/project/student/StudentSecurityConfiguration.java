package com.example.demo.project.student;

import com.example.demo.project.score.infrastructure.repository.ScoreMessageMapper;
import com.example.demo.project.student.infrastructure.repository.MybatisStudentRepository;
import com.example.demo.project.student.infrastructure.repository.StudentRepository;
import com.example.demo.project.student.infrastructure.repository.StudentRowMapper;
import com.example.demo.project.subject.infrastructure.repository.SubjectMapper;
import com.example.demo.project.teacher.infrastructure.repository.TeacherMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentSecurityConfiguration {


    @Bean
    public StudentRepository studentRepository(StudentRowMapper studentRowMapper, ScoreMessageMapper scoreMessageMapper, TeacherMapper teacherMapper, SubjectMapper subjectMapper){
        return new MybatisStudentRepository(studentRowMapper,scoreMessageMapper,teacherMapper,subjectMapper);
    }
}
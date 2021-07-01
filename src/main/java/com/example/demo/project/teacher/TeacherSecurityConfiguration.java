package com.example.demo.project.teacher;

import com.example.demo.project.subject.infrastructure.repository.SubjectMapper;
import com.example.demo.project.teacher.infrastructure.repository.MybatisTeacherRepository;
import com.example.demo.project.teacher.infrastructure.repository.TeacherMapper;
import com.example.demo.project.teacher.infrastructure.repository.TeacherRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherSecurityConfiguration {
    @Bean
    public TeacherRepository teacherRepository(TeacherMapper teacherMapper, SubjectMapper subjectMapper){
        return new MybatisTeacherRepository(teacherMapper,subjectMapper);
    }


}

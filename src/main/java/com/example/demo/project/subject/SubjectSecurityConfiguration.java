package com.example.demo.project.subject;

import com.example.demo.project.subject.infrastructure.repository.MybatisSubjectRepository;
import com.example.demo.project.subject.infrastructure.repository.SubjectMapper;
import com.example.demo.project.subject.infrastructure.repository.SubjectRepository;
import com.example.demo.project.teacher.infrastructure.repository.TeacherMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectSecurityConfiguration {
    @Bean
    public SubjectRepository subjectRepository(SubjectMapper subjectMapper, TeacherMapper teacherMapper){
        return new MybatisSubjectRepository(subjectMapper,teacherMapper);
    }
}

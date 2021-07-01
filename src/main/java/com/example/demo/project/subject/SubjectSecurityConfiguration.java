package com.example.demo.project.subject;

import com.example.demo.project.subject.infrastructure.repository.MybatisSubjectRepository;
import com.example.demo.project.subject.infrastructure.repository.SubjectMapper;
import com.example.demo.project.subject.infrastructure.repository.SubjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectSecurityConfiguration {
    @Bean
    public SubjectRepository subjectRepository(SubjectMapper subjectMapper){
        return new MybatisSubjectRepository(subjectMapper);
    }
}

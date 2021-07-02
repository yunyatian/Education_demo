package com.example.demo.project.subject.infrastructure.repository;

import com.example.demo.project.teacher.domain.Teacher;
import com.example.demo.project.teacher.infrastructure.repository.TeacherMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisSubjectRepository implements SubjectRepository{
    private SubjectMapper subjectMapper;
    private TeacherMapper teacherMapper;

    public MybatisSubjectRepository(SubjectMapper subjectMapper, TeacherMapper teacherMapper) {
        this.subjectMapper = subjectMapper;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> singleSubjectDto(String subject) {
        return teacherMapper.getTeacherBySubject(subject);
    }

}

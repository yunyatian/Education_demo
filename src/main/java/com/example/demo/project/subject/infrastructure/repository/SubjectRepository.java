package com.example.demo.project.subject.infrastructure.repository;

import com.example.demo.project.teacher.domain.Teacher;

import java.util.List;

public interface SubjectRepository {
    List<Teacher> singleSubjectDto (String subject);
}

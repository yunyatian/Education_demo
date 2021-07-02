package com.example.demo.project.subject.infrastructure.repository;

import com.example.demo.project.subject.domain.SubjectRow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper {
    SubjectRow getSubjectByName(@Param("name") String subjectName);

    SubjectRow getSubjectById(@Param("id") Integer subjectId);


    void insertSubject(@Param("subject")SubjectRow subjectRow);

}

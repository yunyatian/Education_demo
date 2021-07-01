package com.example.demo.project.subject.infrastructure.repository;

import com.example.demo.project.subject.domain.SubjectRow;
import com.example.demo.project.teacher.domain.TeacherFaculty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubjectMapper {
    SubjectRow getSubjectByName(@Param("name") String subjectName);

    SubjectRow getSubjectById(@Param("id") Integer subjectId);

    List<TeacherFaculty> selectTeacherFaculty(@Param("ids") List<Integer> teacherId);

    void insertSubject(@Param("subject")SubjectRow subjectRow);

    void updateSubject(@Param("ids")String teachersId,@Param("name") String subjectName);
}

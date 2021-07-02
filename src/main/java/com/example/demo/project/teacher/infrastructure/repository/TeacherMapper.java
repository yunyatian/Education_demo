package com.example.demo.project.teacher.infrastructure.repository;

import com.example.demo.project.teacher.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TeacherMapper {
    void insertTeacher(@Param("teacher") Teacher teacher);

    void UpdateTeacher(@Param("teacher") Teacher teacher);

    void deleteTeacher(@Param("jobId") int jobId);

    Teacher getTeacherByID(@Param("jobId") int jobId);

    List<Teacher> fuzzyGetTeacherBySubject(@Param("subject") String subject);

    List<Teacher> preciseGetTeacherBySubject(@Param("subject") String subject);

    List<Teacher> getAllTeacher();

}

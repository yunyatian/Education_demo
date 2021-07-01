package com.example.demo.project.student.infrastructure.repository;

import com.example.demo.project.student.domain.StudentRow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentRowMapper {
    void insertStudent(@Param("student") StudentRow studentRow);

    void updateStudent(@Param("student") StudentRow studentRow);

    void deleteStudent(@Param("stuId") Integer stuId);

    StudentRow getStudentByID(@Param("stuId") Integer stuId);

    List<StudentRow> getAllStudents();
}

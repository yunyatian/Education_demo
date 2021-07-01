package com.example.demo.project.teacher.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.project.teacher.domain.Teacher;

public interface TeacherRepository {
    IPage<Teacher> getAllTeacher(Integer pageNum,Integer pageSize);

    IPage<Teacher> getTeacherBySubject(String subjectName,Integer pageNum,Integer pageSize);

    void teacherInductionOrModify(Teacher teacher);

    void teacherDeparture(Integer jobId);

    Teacher getTeacherById(Integer jobId);
}

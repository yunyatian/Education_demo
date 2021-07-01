package com.example.demo.project.student.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.project.score.domain.ScoreMessage;
import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.student.domain.Student;
import com.example.demo.project.student.domain.StudentProperties;

public interface StudentRepository {
    IPage<Student> getAllStudent(Integer pageNum,Integer pageSize);

    Student getStudentById(Integer stuId);

    void entranceOrModifyStudent(Student student);

    void dropStudent(Integer stuId);

    void entryScore(Integer stuId, StudentProperties studentProperties);

    IPage<ScoreMessage> getScore(ScoreSearchDto scoreSearchDto, Integer pageNum, Integer pageSize);


}

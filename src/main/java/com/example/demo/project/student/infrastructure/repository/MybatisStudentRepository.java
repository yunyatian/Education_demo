package com.example.demo.project.student.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.project.subject.infrastructure.repository.*;
import com.example.demo.project.score.domain.ScoreMessage;
import com.example.demo.project.score.domain.ScoreMessageRow;
import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.score.infrastructure.repository.ScoreMessageAssembler;
import com.example.demo.project.score.infrastructure.repository.ScoreMessageMapper;
import com.example.demo.project.student.domain.Student;
import com.example.demo.project.student.domain.StudentProperties;
import com.example.demo.project.student.domain.StudentRow;
import com.example.demo.project.teacher.domain.Teacher;
import com.example.demo.project.teacher.infrastructure.repository.TeacherMapper;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

@Repository
public class MybatisStudentRepository implements StudentRepository {
    private StudentRowMapper studentRowMapper;
    private ScoreMessageMapper scoreMessageMapper;
    private TeacherMapper teacherMapper;
    private SubjectMapper subjectMapper;
    private StudentAssembler assembler = new StudentAssembler();
    private ScoreMessageAssembler messageAssembler = new ScoreMessageAssembler();

    public MybatisStudentRepository(StudentRowMapper studentRowMapper, ScoreMessageMapper scoreMessageMapper, TeacherMapper teacherMapper, SubjectMapper subjectMapper) {
        this.studentRowMapper = studentRowMapper;
        this.scoreMessageMapper = scoreMessageMapper;
        this.teacherMapper = teacherMapper;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public IPage<Student> getAllStudent(Integer pageNum, Integer pageSize) {
        IPage<Student> page = new Page<>();
        List<StudentRow> studentRows = studentRowMapper.getAllStudents();
        List<Student> students = new LinkedList<>();
        studentRows.stream().forEach(studentRow -> students.add(assembler.studentRowToStudent(studentRow)));
        page.setTotal(students.size());
        page.setRecords(students.stream().skip((pageNum - 1)*pageSize).limit(pageSize).collect(Collectors.toList()));
        return page;
    }

    @Override
    public Student getStudentById(Integer stuId) {
        return assembler.studentRowToStudent(studentRowMapper.getStudentByID(stuId));
    }

    @Override
    public void entranceOrModifyStudent(Student student) {
        StudentRow studentRow = studentRowMapper.getStudentByID(student.getStuId());
        if (studentRow != null){
            studentRowMapper.updateStudent(assembler.studentRowFromStudent(student));
        }else {
            studentRowMapper.insertStudent(assembler.studentRowFromStudent(student));
        }
    }

    @Override
    public void dropStudent(Integer stuId) {
        studentRowMapper.deleteStudent(stuId);
    }

    @Override
    public void entryScore(Integer stuId, StudentProperties studentProperties) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String now = simpleDateFormat.format(date);
        StudentRow studentRow = studentRowMapper.getStudentByID(stuId);
        if (studentRow != null){
            studentProperties.setPeriod(now);
            Student student = assembler.studentRowToStudent(studentRow);
            student = student.PerfectInformation(studentProperties.getTeacher(),studentProperties);
            studentRow = assembler.studentRowFromStudent(student);
            studentRowMapper.updateStudent(studentRow);
            ScoreMessageRow scoreMessageRow = ScoreMessageRow.builder()
                                                        .studentId(stuId)
                                                        .studentName(studentRow.getName())
                                                        .subjectId(studentProperties.getSubjectId())
                                                        .subjectName(studentProperties.getSubject())
                                                        .teacherId(studentProperties.getTeacherId())
                                                        .teacherName(studentProperties.getTeacher())
                                                        .score(studentProperties.getScore())
                                                        .period(Instant.now())
                                                        .build();
            if (scoreMessageMapper.getSingleScore(scoreMessageRow.getSubjectId(),scoreMessageRow.getStudentId()) == null) {
                scoreMessageMapper.insertScore(scoreMessageRow);
            }
        }
    }

    @Override
    public IPage<ScoreMessage> getScore(ScoreSearchDto scoreSearchDto, Integer pageNum, Integer pageSize) {
        IPage<ScoreMessage> page = new Page<>();
        List<ScoreMessageRow> scoreMessageRows = scoreMessageMapper.getScore(scoreSearchDto);
        List<ScoreMessage> scoreMessageList = new LinkedList<>();
        scoreMessageRows.stream().forEach(scoreMessageRow -> scoreMessageList.add(messageAssembler.scoreMessageFromScoreMessageRow(scoreMessageRow)));
        page.setTotal(scoreMessageList.size());
        page.setRecords(scoreMessageList.stream().skip((pageNum-1)*pageSize).limit(pageSize).collect(Collectors.toList()));
        return page;
    }

}

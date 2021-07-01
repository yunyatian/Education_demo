package com.example.demo.project.teacher.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.project.subject.domain.SubjectRow;
import com.example.demo.project.subject.infrastructure.repository.SubjectMapper;
import com.example.demo.project.teacher.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MybatisTeacherRepository implements TeacherRepository {

    private TeacherMapper teacherMapper;
    private SubjectMapper subjectMapper;

    public MybatisTeacherRepository(TeacherMapper teacherMapper, SubjectMapper subjectMapper) {
        this.teacherMapper = teacherMapper;
        this.subjectMapper = subjectMapper;
    }

    @Override
    public IPage<Teacher> getAllTeacher(Integer pageNum, Integer pageSize) {
        IPage<Teacher> page = new Page<>();
        List<Teacher> teachers = teacherMapper.getAllTeacher();
        page.setTotal(teachers.size());
        page.setRecords(teachers.stream().skip((pageNum-1)*pageSize).limit(pageSize).collect(Collectors.toList()));
        return page;
    }

    @Override
    public IPage<Teacher> getTeacherBySubject(String subjectName, Integer pageNum, Integer pageSize) {
        IPage<Teacher> page = new Page<>();
        List<Teacher> teachers = teacherMapper.getTeacherBySubject(subjectName);
        page.setTotal(teachers.size());
        page.setRecords(teachers.stream().skip((pageNum-1)*pageSize).limit(pageSize).collect(Collectors.toList()));
        return page;
    }

    @Override
    public void teacherInductionOrModify(Teacher teacher) {
        Teacher oldTeacher = teacherMapper.getTeacherByID(Integer.parseInt(teacher.getJobId()));
        if (oldTeacher != null){
            teacherMapper.UpdateTeacher(teacher);
        }else {
            teacherMapper.insertTeacher(teacher);
        }
        if(teacher.getSubject() != null && !teacher.getSubject().equals("")){
            SubjectRow subjectRow = subjectMapper.getSubjectByName(teacher.getSubject());
            if (subjectRow == null){
                subjectRow = SubjectRow.builder()
                        .name(teacher.getSubject())
                        .teachersId(teacher.getJobId())
                        .build();
                subjectMapper.insertSubject(subjectRow);
            }else if (subjectRow.getTeachersId() == null || subjectRow.getTeachersId().equals("")){
                subjectMapper.updateSubject(teacher.getJobId(), teacher.getSubject());
            }else if (!subjectRow.getTeachersId().contains(teacher.getJobId())){
                String teacherIds = subjectRow.getTeachersId();
                teacherIds += ","+teacher.getJobId();
                subjectMapper.updateSubject(teacherIds,teacher.getSubject());
            }
        }

    }

    @Override
    public void teacherDeparture(Integer jobId) {
        teacherMapper.deleteTeacher(jobId);
    }

    @Override
    public Teacher getTeacherById(Integer jobId) {
        return teacherMapper.getTeacherByID(jobId);
    }
}

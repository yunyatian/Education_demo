package com.example.demo.project.subject.infrastructure.repository;

import com.example.demo.project.subject.domain.SubjectDto;
import com.example.demo.project.subject.domain.SubjectRow;
import com.example.demo.project.teacher.domain.TeacherFaculty;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MybatisSubjectRepository implements SubjectRepository{
    private SubjectMapper subjectMapper;

    public MybatisSubjectRepository(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectDto singleSubjectDto(Integer subjectId) {
        SubjectRow subjectRow = subjectMapper.getSubjectById(subjectId);
        if (subjectRow != null) {
            List<Integer> ids = Arrays.stream(subjectRow.getTeachersId().split(","))
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            List<TeacherFaculty> teacherFaculties = subjectMapper.selectTeacherFaculty(ids);
            return SubjectDto.builder()
                    .name(subjectRow.getName())
                    .subId(subjectId)
                    .teachers(teacherFaculties)
                    .build();
        }else {
            return null;
        }
    }

}

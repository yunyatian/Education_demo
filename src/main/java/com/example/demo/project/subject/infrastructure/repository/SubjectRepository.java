package com.example.demo.project.subject.infrastructure.repository;

import com.example.demo.project.subject.domain.SubjectDto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SubjectRepository {
    SubjectDto singleSubjectDto (Integer subjectId);
}

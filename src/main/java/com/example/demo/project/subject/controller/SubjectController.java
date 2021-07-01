package com.example.demo.project.subject.controller;

import com.example.demo.project.subject.infrastructure.repository.SubjectRepository;
import com.example.demo.project.util.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/edu/subject")
@RestController
@Slf4j
public class SubjectController {
    private SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/get/{id}"
    )
    public ResultBody singleSubjectMessage(@PathVariable("id")Integer subjectId){
        try{
            return ResultBody.success(subjectRepository.singleSubjectDto(subjectId));
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }

}

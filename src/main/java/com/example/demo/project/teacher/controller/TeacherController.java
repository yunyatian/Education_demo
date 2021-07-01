package com.example.demo.project.teacher.controller;

import com.example.demo.project.util.ResultBody;
import com.example.demo.project.teacher.domain.Teacher;
import com.example.demo.project.teacher.infrastructure.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequestMapping("/edu/teacher")
@RestController
@Slf4j
public class TeacherController {
    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/search"
    )
    public ResultBody searchAllTeacher(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        try {
            return ResultBody.success(teacherRepository.getAllTeacher(pageNum, pageSize));
        } catch (Exception e) {
            return ResultBody.error(e.getMessage());
        }
    }

    @RequestMapping(
            method = GET,
            path = "/search/{name}"
    )
    public ResultBody searchTeacherBySubjectName(@PathVariable("name") String subject,
                                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        try {
            return ResultBody.success(teacherRepository.getTeacherBySubject(subject, pageNum, pageSize));
        } catch (Exception e) {
            return ResultBody.error(e.getMessage());
        }

    }

    @RequestMapping(
            method = GET,
            path = "/get/{id}"
    )
    public ResultBody searchTeacherBySubjectName(@PathVariable("id") Integer subjectId,
                                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        try {
            return ResultBody.success(teacherRepository.getTeacherById(subjectId));
        } catch (Exception e) {
            return ResultBody.error(e.getMessage());
        }
    }

    @RequestMapping(
            method = POST,
            path = "/induction"
    )
    public ResultBody inductTeacher(@RequestBody Teacher teacher){
        try{
            teacherRepository.teacherInductionOrModify(teacher);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }

    @RequestMapping(
            method = PUT,
            path = "/alter"
    )
    public ResultBody alterTeacher(@RequestBody Teacher teacher){
        try{
            teacherRepository.teacherInductionOrModify(teacher);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }

    @RequestMapping(
            method = DELETE,
            path = "/remove/{id}"
    )
    public ResultBody departureTeacher(@PathVariable("id")Integer id){
        try{
            teacherRepository.teacherDeparture(id);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }
}

package com.example.demo.project.student.controller;

import com.example.demo.project.student.domain.StudentProperties;
import com.example.demo.project.util.ResultBody;
import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.student.domain.Student;
import com.example.demo.project.student.infrastructure.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edu/student")
@Slf4j
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//    IPage<Student> getAllStudent(Integer pageNum, Integer pageSize);
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/search"
    )
    public ResultBody searchAllStudent(@RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                       @RequestParam(required = false,defaultValue = "10")Integer pageSize){
        try{
            return ResultBody.success(studentRepository.getAllStudent(pageNum,pageSize));
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }
//
//    Student getStudentById(Integer stuId);
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/get/{id}"
    )
    public ResultBody getStudentById(@PathVariable("id")Integer stuId){
        try{
            return ResultBody.success(studentRepository.getStudentById(stuId));
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
     }
}
//
//    void entranceOrModifyStudent(Student student);
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/entrance"
    )
    public ResultBody entrySchool(@RequestBody Student student){
        try{
            studentRepository.entranceOrModifyStudent(student);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/alter"
    )
    public ResultBody modifyStudent(@RequestBody Student student){
        try{
            studentRepository.entranceOrModifyStudent(student);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }

//
//    void dropStudent(Integer stuId);
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/drop/{id}"
    )
    public ResultBody dropSchool(@PathVariable("id")Integer id){
        try{
            studentRepository.dropStudent(id);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }
//
//    void entryScore(Integer stuId, String subject, Integer score, Integer teacherId);
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/record/score"
    )
    public ResultBody recordScore(@RequestParam Integer stuId,
                                  @RequestBody StudentProperties studentProperties){
        try{
            studentRepository.entryScore(stuId,studentProperties);
            return ResultBody.success();
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }
//
//    List<ScoreMessage> getScore(Integer subId);

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/get_score"
    )
    public ResultBody ObtainScore(@RequestBody ScoreSearchDto scoreSearchDto,
                                  @RequestParam(required = false,defaultValue = "1")Integer pageNum,
                                  @RequestParam(required = false,defaultValue = "10")Integer pageSize){
        try{
            return ResultBody.success(studentRepository.getScore(scoreSearchDto, pageNum, pageSize));
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }
//
//    List<ScoreMessage> getScoreByPeriod(Integer subId, Instant period);

}

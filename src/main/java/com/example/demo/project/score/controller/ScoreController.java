package com.example.demo.project.score.controller;

import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.score.infrastructure.repository.ScoreRepository;
import com.example.demo.project.util.ResultBody;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("edu/score")
@Slf4j
public class ScoreController {
    private ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/average"
    )
    public ResultBody averageScore(@RequestBody ScoreSearchDto scoreSearchDto){
        try{
            return ResultBody.success(scoreRepository.averageScore(scoreSearchDto));
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/rank"
    )
    public ResultBody rankScore(@RequestBody ScoreSearchDto scoreSearchDto){
        try{
            return ResultBody.success(scoreRepository.totalScoreRanked(scoreSearchDto));
        }catch (Exception e){
            return ResultBody.error(e.getMessage());
        }
    }
}

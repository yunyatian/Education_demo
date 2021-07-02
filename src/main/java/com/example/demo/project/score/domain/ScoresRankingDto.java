package com.example.demo.project.score.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

@Data
public class ScoresRankingDto {
    private Integer studentId;
    private String studentName;
    private Integer sumScore;
    @JsonFormat(pattern = "YYYY-MM-dd",locale = "zh",timezone = "GMT+8")
    private Instant period;
}

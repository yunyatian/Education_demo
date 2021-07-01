package com.example.demo.project.score.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class ScoreMessage {
    private String studentName;
    private String subject;
    private String teacherName;
    private int score;
    @JsonFormat(pattern = "YYYY-MM-dd" ,locale = "zh" ,timezone = "GMT+8")
    private Instant period;

}

package com.example.demo.project.score.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

@Data
public class ScoreSearchDto {
    private Integer stuId;
    //使用DD显示的日期是一年当中该天的天数，不是某一个月的天数
    @JsonFormat(pattern = "YYYY-MM-dd" ,locale = "zh" ,timezone = "GMT+8")
    private Instant period;
    private String subject;
}

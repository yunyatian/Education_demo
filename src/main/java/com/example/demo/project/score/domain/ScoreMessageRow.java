package com.example.demo.project.score.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@TableName(value = "score_message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreMessageRow {
    private Integer studentId;
    private String studentName;
    private Integer subjectId;
    private String subjectName;
    private Integer teacherId;
    private String teacherName;
    private Integer score;
    @JsonFormat(pattern = "YYYY-MM-dd" ,locale = "zh" ,timezone = "GMT+8")
    private Instant period;
}

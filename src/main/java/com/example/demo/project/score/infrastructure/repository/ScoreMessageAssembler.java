package com.example.demo.project.score.infrastructure.repository;

import com.example.demo.project.score.domain.ScoreMessage;
import com.example.demo.project.score.domain.ScoreMessageRow;

public class ScoreMessageAssembler {
    public ScoreMessage scoreMessageFromScoreMessageRow(ScoreMessageRow scoreMessageRow){
        return ScoreMessage.builder()
                .studentName(scoreMessageRow.getStudentName())
                .teacherName(scoreMessageRow.getTeacherName())
                .subject(scoreMessageRow.getSubjectName())
                .score(scoreMessageRow.getScore())
                .period(scoreMessageRow.getPeriod())
                .build();
    }
}

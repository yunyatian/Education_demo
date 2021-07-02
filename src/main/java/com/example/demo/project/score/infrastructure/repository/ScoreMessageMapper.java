package com.example.demo.project.score.infrastructure.repository;

import com.example.demo.project.score.domain.ScoreMessageRow;
import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.score.domain.ScoresRankingDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.Instant;
import java.util.List;

@Mapper
public interface ScoreMessageMapper {
    List<ScoreMessageRow> getScore(@Param("score")ScoreSearchDto scoreSearchDto);

    Integer getSingleScore(@Param("subjectId") int subjectId, @Param("studentId") int studentId);

    void insertScore(@Param("score") ScoreMessageRow scoreMessageRow);

    Integer getAverageScore(@Param("score") ScoreSearchDto scoreSearchDto);

    List<ScoresRankingDto> rankScore(@Param("score") ScoreSearchDto scoreSearchDto);
}

package com.example.demo.project.score.infrastructure.repository;

import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.score.domain.ScoresRankingDto;

import java.time.Instant;
import java.util.List;

public interface ScoreRepository {
    Integer averageScore(ScoreSearchDto scoreSearchDto);

    List<ScoresRankingDto> totalScoreRanked (ScoreSearchDto scoreSearchDto);
}

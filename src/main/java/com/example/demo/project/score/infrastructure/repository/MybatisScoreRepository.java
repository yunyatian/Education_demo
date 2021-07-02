package com.example.demo.project.score.infrastructure.repository;

import com.example.demo.project.score.domain.ScoreSearchDto;
import com.example.demo.project.score.domain.ScoresRankingDto;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public class MybatisScoreRepository implements ScoreRepository{
    private ScoreMessageMapper scoreMessageMapper;

    public MybatisScoreRepository(ScoreMessageMapper scoreMessageMapper) {
        this.scoreMessageMapper = scoreMessageMapper;
    }

    @Override
    public Integer averageScore(ScoreSearchDto scoreSearchDto) {
        return scoreMessageMapper.getAverageScore(scoreSearchDto);
    }

    @Override
    public List<ScoresRankingDto> totalScoreRanked(ScoreSearchDto scoreSearchDto) {
        return scoreMessageMapper.rankScore(scoreSearchDto);
    }
}

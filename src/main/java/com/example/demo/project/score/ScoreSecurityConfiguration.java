package com.example.demo.project.score;

import com.example.demo.project.score.infrastructure.repository.MybatisScoreRepository;
import com.example.demo.project.score.infrastructure.repository.ScoreMessageMapper;
import com.example.demo.project.score.infrastructure.repository.ScoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScoreSecurityConfiguration {
    @Bean
    public ScoreRepository scoreRepository(ScoreMessageMapper scoreMessageMapper){
        return new MybatisScoreRepository(scoreMessageMapper);
    }
}


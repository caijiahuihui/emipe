package com.caicai.emipe.service;

import com.caicai.emipe.persistence.entity.ScoreFlow;
import com.caicai.emipe.persistence.repository.ScoreFlowRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author caicai
 * @create 2021/3/15
 */
@Service
@Slf4j
public class ScoreFlowService {

    @Autowired
    private ScoreFlowRepository scoreFlowRepository;

    @Transactional
    public String batchSave(List<Long> list){
        List<ScoreFlow> scores = new ArrayList<>();
        for(Long score:list){
            ScoreFlow flow = new ScoreFlow();
            flow.setScore(score);
            scores.add(flow);
        }
        scoreFlowRepository.saveAll(scores);
        log.error("-------saveAll----------");
        return "SUCCESS";
    }

    @Transactional
    public String simpleSave(List<Long> list){
        for(Long score :list){
            scoreFlowRepository.save(new ScoreFlow(null,new Date(),true,new Date(),false,"caicaicai","obj_id123456",1,score,"hahahah","heiheihei"));
        }
        log.error("-------simpleSave----------");
        return "SUCCESS";
    }

}

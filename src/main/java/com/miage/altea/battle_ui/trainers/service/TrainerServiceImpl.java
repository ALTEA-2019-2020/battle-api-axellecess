package com.miage.altea.battle_ui.trainers.service;

import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class TrainerServiceImpl implements TrainerService {

    private RestTemplate restTemplate;
    private String trainerServiceUrl;

    @Override
    public BattleTrainer getTrainer(String name) {
        Trainer trainer = restTemplate.getForObject(trainerServiceUrl + "/trainers/" + name, Trainer.class);

        BattleTrainer battleTrainer = new BattleTrainer();
        battleTrainer.setName(trainer.getName());
        battleTrainer.setNextTurn(false);

        return battleTrainer;
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }
}

package com.miage.altea.battle_ui.service;

import com.miage.altea.battle_ui.battle.Battle;
import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.trainers.bo.Trainer;
import com.miage.altea.battle_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BattleService {

    @Autowired
    TrainerService trainerService;

    public Battle createBattle(String trainerName, String opponentName){
        Battle battle = new Battle();

        BattleTrainer trainer = trainerService.getTrainer(trainerName);
        BattleTrainer opponent = trainerService.getTrainer(opponentName);

        battle.setTrainer(trainer);
        battle.setOpponent(opponent);

        return  battle;
    }
}

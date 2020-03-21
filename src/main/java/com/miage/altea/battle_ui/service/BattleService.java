package com.miage.altea.battle_ui.service;

import com.miage.altea.battle_ui.battle.Battle;
import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BattleService {

    public Battle createBattle(){
        Battle battle = new Battle();

        return  battle;
    }
}

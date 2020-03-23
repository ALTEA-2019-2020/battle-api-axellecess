package com.miage.altea.battle_ui.service;

import com.miage.altea.battle_ui.battle.Battle;
import com.miage.altea.battle_ui.battle.BattlePokemon;
import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BattleService {

    @Autowired
    TrainerService trainerService;

    @Autowired
    StatsCalculator statsCalculator;

    private HashMap<String, Battle> battles = new HashMap<>();

    public Battle createBattle(String trainerName, String opponentName){
        Battle battle = new Battle();

        BattleTrainer trainer = trainerService.getTrainer(trainerName);
        BattleTrainer opponent = trainerService.getTrainer(opponentName);

        if(trainer.getTeam().get(0).getSpeed() >= opponent.getTeam().get(0).getSpeed()){
            trainer.setNextTurn(true);
        }
        else {
            opponent.setNextTurn(true);
        }

        battle.setTrainer(trainer);
        battle.setOpponent(opponent);

        UUID uuid = UUID.randomUUID();
        battle.setUuid(uuid.toString());

        battles.put(uuid.toString(), battle);

        return  battle;
    }

    public Battle getBattle(String uuid) {
        return battles.get(uuid);
    }

    public List<Battle> getBattles() {
        return (List<Battle>) battles.values();
    }

    public Battle attack(String uuid, String trainerName ) {
        Battle battle = getBattle(uuid);

        BattleTrainer trainer = new BattleTrainer();
        if(battle.getOpponent().getName().equals(trainerName)){
            trainer = battle.getOpponent();
        }
        else if (battle.getTrainer().getName().equals(trainerName)){
            trainer = battle.getOpponent();
        }

        for (BattlePokemon battlePokemon : trainer.getTeam()){
            if(battlePokemon.isAlive()){
                int damage = statsCalculator.calculateDamage(battlePokemon.getLevel(), battlePokemon.getAttack(), battlePokemon.getDefense() );
                battlePokemon.setHp(battlePokemon.getHp() - damage);

                if(battlePokemon.getHp() <= 0){
                    battlePokemon.setAlive(false);
                    battlePokemon.setKo(true);
                }

            }
        }

        trainer.setNextTurn(true);
        if(battle.getOpponent().getName().equals(trainerName)){
            battle.getOpponent().setNextTurn(true);
            battle.getTrainer().setNextTurn(false);
        }
        else if (battle.getTrainer().getName().equals(trainerName)){
            battle.getOpponent().setNextTurn(false);
            battle.getTrainer().setNextTurn(true);
        }

        return battle;
    }
}

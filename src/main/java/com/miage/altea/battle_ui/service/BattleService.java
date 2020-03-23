package com.miage.altea.battle_ui.service;

import com.miage.altea.battle_ui.battle.Battle;
import com.miage.altea.battle_ui.battle.BattlePokemon;
import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.repository.BattleRepository;
import com.miage.altea.battle_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BattleService {

    @Autowired
    TrainerService trainerService;

    @Autowired
    BattleRepository battleRepository;

    @Autowired
    StatsCalculator statsCalculator;

    public Battle createBattle(String trainerName, String opponentName){
        Battle battle = new Battle();

        BattleTrainer trainer = trainerService.getTrainer(trainerName);
        BattleTrainer opponent = trainerService.getTrainer(opponentName);

        battle.setTrainer(trainer);
        battle.setOpponent(opponent);

        UUID uuid = UUID.randomUUID();
        battle.setUuid(uuid.toString());

        battleRepository.save(battle);

        return  battle;
    }

    public Battle getBattle(String uuid) {
        return battleRepository.findById(uuid).orElse(null);
    }

    public List<Battle> getBattles() {
        return (List<Battle>) battleRepository.findAll();
    }

    public Battle attack(String uuid, String trainerName ) {
        Battle battle = getBattle(uuid);
        BattleTrainer trainer = trainerService.getTrainer(trainerName);

        for (BattlePokemon battlePokemon : trainer.getTeam()){
            if(battlePokemon.isAlive()){
                int damage = statsCalculator.calculateDamage(battlePokemon.getLevel(), battlePokemon.getAttack(), battlePokemon.getDefense() );
                battlePokemon.setHp(battlePokemon.getHp() - damage);

                if(battlePokemon.getHp() <= 0){
                    battlePokemon.setAlive(false);
                    battlePokemon.setKo(true);
                }

                return battle;
            }
        }

        trainer.setNextTurn(true);

        battleRepository.save(battle);
        return battle;
    }
}

package com.miage.altea.battle_ui.trainers.service;

import com.miage.altea.battle_ui.battle.BattlePokemon;
import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.battle_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.battle_ui.service.BattlePokemonFactory;
import com.miage.altea.battle_ui.trainers.bo.Pokemon;
import com.miage.altea.battle_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class TrainerServiceImpl implements TrainerService {

    private RestTemplate restTemplate;
    private String trainerServiceUrl;

    @Autowired
    PokemonTypeService pokemonTypeService;

    @Autowired
    BattlePokemonFactory battlePokemonFactory;

    @Override
    public BattleTrainer getTrainer(String name) {
        Trainer trainer = restTemplate.getForObject(trainerServiceUrl + "/trainers/" + name, Trainer.class);

        BattleTrainer battleTrainer = new BattleTrainer();
        battleTrainer.setName(trainer.getName());
        battleTrainer.setNextTurn(false);
        battleTrainer.setTeam(new ArrayList<>());

        for(Pokemon pokemon : trainer.getTeam()){
            battleTrainer.getTeam().add(getBattlePokemon(pokemon));
        }

        return battleTrainer;
    }

    public BattlePokemon getBattlePokemon(Pokemon pokemon){
        PokemonType pokemonType = pokemonTypeService.getPokemonType(pokemon.getPokemonTypeId());
        return battlePokemonFactory.createBattlePokemon(pokemonType,1);
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

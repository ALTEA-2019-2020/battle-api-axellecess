package com.miage.altea.battle_ui.service;

import com.miage.altea.battle_ui.battle.BattlePokemon;
import com.miage.altea.battle_ui.pokemonTypes.bo.PokemonType;

@Service
public class BattlePokemonFactory {

    @Autowired
    public StatsCalculator statsCalculator;

    public BattlePokemon createBattlePokemon(PokemonType pokemonType, int level){
        BattlePokemon battlePokemon = new BattlePokemon();

        battlePokemon.setHp(statsCalculator.calculateHp(pokemonType.getStats().getHp(), level));
        battlePokemon.setMaxHp(statsCalculator.calculateHp(pokemonType.getStats().getHp(), level));

        battlePokemon.setAttack(statsCalculator.calculateStat(pokemonType.getStats().getAttack(), level));
        battlePokemon.setDefense(statsCalculator.calculateStat(pokemonType.getStats().getDefense(), level));
        battlePokemon.setSpeed(statsCalculator.calculateStat(pokemonType.getStats().getSpeed(), level));

        battlePokemon.setLevel(level);

        battlePokemon.setKo(false);
        battlePokemon.setAlive(true);

        battlePokemon.setType(pokemonType);

        return battlePokemon;
    }
}

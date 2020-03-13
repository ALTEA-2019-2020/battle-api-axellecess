package com.miage.altea.battle_ui.service;

public class StatsCalculator {

    public int calculateHp(int base, int level){
        int hp = 10 + level + (base * (level / 50));
        return hp;
    }

    public int calculateStat(int base, int level){
        int stats = 5 + (base * (level / 50));
        return stats;
    }

    public int calculateDamage(int level, int attack, int defense){
        int damage = (2 * level)/5 + 2*(attack/defense) + 2;
        return damage;
    }
}

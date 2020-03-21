package com.miage.altea.battle_ui.battle;

import com.miage.altea.battle_ui.pokemonTypes.bo.PokemonType;

public class BattlePokemon {

    private int hp;
    private int maxHp;

    private int attack;
    private int defense;
    private int speed;

    private int level;

    private boolean ko;
    private boolean alive;

    private PokemonType type;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isKo() {
        return ko;
    }

    public void setKo(boolean ko) {
        this.ko = ko;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }
}

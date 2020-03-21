package com.miage.altea.battle_ui.battle;

public class Battle {

    private String uuid;
    private BattleTrainer trainer;
    private BattleTrainer opponent;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BattleTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(BattleTrainer trainer) {
        this.trainer = trainer;
    }

    public BattleTrainer getOpponent() {
        return opponent;
    }

    public void setOpponent(BattleTrainer opponent) {
        this.opponent = opponent;
    }
}

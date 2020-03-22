package com.miage.altea.battle_ui.controller;

import com.miage.altea.battle_ui.battle.Battle;
import com.miage.altea.battle_ui.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BattleController {

    @Autowired
    BattleService battleService;

    @PostMapping(value = "/battles")
    public ModelAndView createBattle(@RequestParam(value = "trainer", required = false) String trainer,
                                     @RequestParam(value = "opponent", required = false) String opponent){
        Battle battle = battleService.createBattle(trainer, opponent);
        return null;
    }

    @GetMapping("/battles")
    public ModelAndView getBattles(){
        return null;
    }

    @GetMapping("/battles/{uuid}")
    public ModelAndView getOneBattle(@PathVariable String uuid){
        return null;
    }

    @PostMapping("/battles/{uuid}/{trainerName}/attack")
    public ModelAndView attack(@PathVariable String uuid, @PathVariable String trainerName){
        return null;
    }
}

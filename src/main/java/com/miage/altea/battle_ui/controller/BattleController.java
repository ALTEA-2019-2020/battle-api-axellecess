package com.miage.altea.battle_ui.controller;

import com.miage.altea.battle_ui.battle.Battle;
import com.miage.altea.battle_ui.battle.BattleTrainer;
import com.miage.altea.battle_ui.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@Controller
public class BattleController {

    @Autowired
    BattleService battleService;

    @PostMapping(value = "/battles")
    public Battle createBattle(@RequestParam(value = "trainer", required = false) String trainer,
                                     @RequestParam(value = "opponent", required = false) String opponent){
        Battle battle = battleService.createBattle(trainer, opponent);
        return battle;
    }

    @GetMapping("/battles")
    public List<Battle> getBattles(){
        return battleService.getBattles();
    }

    @GetMapping("/battles/{uuid}")
    public Battle getOneBattle(@PathVariable String uuid){
        return battleService.getBattle(uuid);
    }

    @PostMapping("/battles/{uuid}/{trainerName}/attack")
    public Battle attack(@PathVariable String uuid, @PathVariable String trainerName){
        return battleService.attack(uuid, trainerName);
    }

    @GetMapping("/fight/{opponent}")
    public ModelAndView fight(Principal principal, @PathVariable String opponent){
        var modelAndView = new ModelAndView("fight");

        modelAndView.addObject("trainerName", principal.getName());
        modelAndView.addObject("opponentName", opponent);

        return modelAndView;
    }
}

package com.miage.altea.battle_ui.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BattleControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(BattleController.class.getAnnotation(Controller.class));
    }

    @Test
    void method_shouldBeAnnotated() throws NoSuchMethodException {
        var battleMethod = BattleController.class.getDeclaredMethod("getBattles");
        var getMapping = battleMethod.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/battles"}, getMapping.value());
    }
}

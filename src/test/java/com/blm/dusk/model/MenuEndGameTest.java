package com.blm.dusk.model;

import com.blm.dusk.models.menu.MenuEndGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuEndGameTest {
    MenuEndGame menuEndGame;

    @BeforeEach
    public void setUp(){
        menuEndGame = new MenuEndGame();
    }
    @Test
    public void getEntries(){
        menuEndGame.nextEntry();
        assertEquals(true, menuEndGame.isSelectedExit());
        menuEndGame.nextEntry();
        assertEquals(true, menuEndGame.isSelectedBackMenu());
        menuEndGame.previousEntry();
        assertEquals(true,menuEndGame.isSelected(1));
        assertEquals("Exit", menuEndGame.getEntry(1));
        assertEquals(2,menuEndGame.getNumberEntries());

    }
}

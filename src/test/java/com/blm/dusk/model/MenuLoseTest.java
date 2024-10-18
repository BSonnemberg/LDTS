package com.blm.dusk.model;

import com.blm.dusk.models.menu.MenuLose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuLoseTest {
    MenuLose menuLose;

    @BeforeEach
    public void setUp(){
        menuLose = new MenuLose();
    }

    @Test
    public void getEntries(){
        menuLose.nextEntry();
        assertEquals(true, menuLose.isSelectedBackMenu());
        assertEquals(false, menuLose.isSelectedPlayAgain());
        menuLose.previousEntry();
        assertEquals(true,menuLose.isSelected(0));
        assertEquals("Back Menu", menuLose.getEntry(1));
        assertEquals(2,menuLose.getNumberEntries());
        assertEquals(1,menuLose.getCurrentLevel());
    }
}

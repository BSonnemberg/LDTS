package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.menu.MenuLoseController;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.MenuLose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuLoseControllerTest {
    MenuLoseController menuLoseController;
    MenuLose menuLose;
    Application application;

    @BeforeEach
    void setUp(){
        menuLose = Mockito.mock(MenuLose.class);
        application = Mockito.mock(Application.class);
        menuLoseController = new MenuLoseController(menuLose);
    }
    @Test
    public void stepUp() throws IOException {
        menuLoseController.step(application, LanternaGUI.ACTION.UP, 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedBackMenu();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedPlayAgain();
    }

    @Test
    public void stepDown() throws IOException {
        menuLoseController.step(application, LanternaGUI.ACTION.DOWN, 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedBackMenu();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).isSelectedPlayAgain();
    }

    @Test
    public void stepSelectBackToMenu() throws IOException {

        Mockito.when(menuLoseController.getModel().isSelectedBackMenu()).thenReturn(true);

        menuLoseController.step(application, LanternaGUI.ACTION.SELECT, 1000);

        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).isSelectedPlayAgain();
        Mockito.verify(menuLoseController.getModel(), Mockito.times(1)).isSelectedBackMenu();
    }

}

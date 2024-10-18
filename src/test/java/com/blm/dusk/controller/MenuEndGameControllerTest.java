package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.menu.MenuEndGameController;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.MenuEndGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuEndGameControllerTest {
    MenuEndGameController menuEndGameController;
    MenuEndGame menuEndGame;
    Application application;

    @BeforeEach
    void setUp(){
        menuEndGame = Mockito.mock(MenuEndGame.class);
        application = Mockito.mock(Application.class);
        menuEndGameController = new MenuEndGameController(menuEndGame);
    }
    @Test
    public void stepUp() throws IOException {
        menuEndGameController.step(application, LanternaGUI.ACTION.UP, 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedBackMenu();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }
    @Test
    public void stepDown() throws IOException {
        menuEndGameController.step(application, LanternaGUI.ACTION.DOWN, 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).isSelectedBackMenu();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectBacktoMainMenu() throws IOException {

        Mockito.when(menuEndGameController.getModel().isSelectedBackMenu()).thenReturn(true);

        menuEndGameController.step(application, LanternaGUI.ACTION.SELECT, 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedBackMenu();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }
    @Test
    public void stepSelectExit() throws IOException {
        Mockito.when(menuEndGameController.getModel().isSelectedExit()).thenReturn(true);
        menuEndGameController.step(application, LanternaGUI.ACTION.SELECT, 1000);

        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedBackMenu();
        Mockito.verify(menuEndGameController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(application, Mockito.times(1)).setState(null);
    }
}

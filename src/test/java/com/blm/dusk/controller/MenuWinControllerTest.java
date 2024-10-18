package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.menu.MenuWinController;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.MenuWin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuWinControllerTest {
    MenuWinController menuWinController;
    MenuWin menuWin;
    Application application;

    @BeforeEach
    void setUp(){
        menuWin = Mockito.mock(MenuWin.class);
        application = Mockito.mock(Application.class);
        menuWinController = new MenuWinController(menuWin);
    }
    @Test
    public void stepUp() throws IOException {
        menuWinController.step(application, LanternaGUI.ACTION.UP, 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedBackMenu();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedNextLevel();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepDown() throws IOException {
        menuWinController.step(application, LanternaGUI.ACTION.DOWN, 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedBackMenu();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).isSelectedNextLevel();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void stepSelectBackToMenu() throws IOException {

        Mockito.when(menuWinController.getModel().isSelectedBackMenu()).thenReturn(true);

        menuWinController.step(application, LanternaGUI.ACTION.SELECT, 1000);

        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).isSelectedNextLevel();
        Mockito.verify(menuWinController.getModel(), Mockito.times(1)).isSelectedBackMenu();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

}

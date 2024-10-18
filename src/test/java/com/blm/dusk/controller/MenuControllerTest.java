package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.menu.MenuController;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuSettings;
import com.blm.dusk.state.MenuSettingsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuControllerTest {
    private Menu menu;
    private MenuController menuController;
    private Application application;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(Menu.class);
        menuController = new MenuController(menu);
        application = Mockito.mock(Application.class);
    }

    @Test
    void testMovementUpInMenu() throws IOException {
        menuController.step(application, LanternaGUI.ACTION.UP, 100);
        Mockito.verify(menu).previousEntry();
    }

    @Test
    void testMovementDownInMenu() throws IOException {
        menuController.step(application, LanternaGUI.ACTION.DOWN, 100);
        Mockito.verify(menu).nextEntry();
    }

    @Test
    void testSelectExitOption() throws IOException {
        menu.isSelectedExit();
        application.setState(null);
        menuController.step(application, LanternaGUI.ACTION.SELECT, 100);
        Mockito.verify(application).setState(null);
    }

    @Test
    public void stepSelectSettings() throws IOException {

        Mockito.when(menuController.getModel().isSelectedSettings()).thenReturn(true);
        menuController.step(application, LanternaGUI.ACTION.SELECT, 1000);

        Mockito.verify(menuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedSettings();
        Mockito.verify(menuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(application, Mockito.times(0)).setState(null);
    }

    @Test
    public void selectSettings() throws IOException{
        menuController.step(application, LanternaGUI.ACTION.DOWN, 1000);
        menuController.step(application, LanternaGUI.ACTION.SELECT, 1000);
        MenuSettingsState s=new MenuSettingsState(new MenuSettings(false, false));
        application.setState(s);
        assertEquals(null, application.getState());
    }
}

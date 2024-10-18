package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.menu.MenuSettingsController;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.MenuSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuSettingsControllerTest {
    MenuSettingsController menuSettingsController;
    MenuSettings menuSettings;
    Application application;

    @BeforeEach
    void setUp(){
        menuSettings = Mockito.mock(MenuSettings.class);
        application = Mockito.mock(Application.class);
        menuSettingsController = new MenuSettingsController(menuSettings);
    }

    @Test
    public void stepUp() throws IOException {

        menuSettingsController.step(application, LanternaGUI.ACTION.UP, 1000);

        Mockito.verify(menuSettingsController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).isSelectedMusic();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).isSelectedSound();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).setMutemusic();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).setMutesound();
        Mockito.verify(application, Mockito.times(0)).setplayMusic();
        Mockito.verify(application, Mockito.times(0)).setplaySound();

    }

    @Test
    public void stepDown() throws IOException {

        menuSettingsController.step(application, LanternaGUI.ACTION.DOWN, 1000);

        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).isSelectedBacktoMenu();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).isSelectedMusic();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).isSelectedSound();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).setMutemusic();
        Mockito.verify(menuSettingsController.getModel(), Mockito.times(0)).setMutesound();
        Mockito.verify(application, Mockito.times(0)).setplayMusic();
        Mockito.verify(application, Mockito.times(0)).setplaySound();

    }


}

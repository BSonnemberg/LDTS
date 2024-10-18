package com.blm.dusk.model;

import com.blm.dusk.models.menu.MenuSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuSettingsTest {
    MenuSettings menuSettings;

    @BeforeEach
    public void setUp(){
        menuSettings = new MenuSettings(false, false);
    }

    @Test
    public void getEntries(){
        assertEquals(true, menuSettings.isSelectedMusic());
        menuSettings.nextEntry();
        assertEquals(true, menuSettings.isSelectedSound());
        menuSettings.nextEntry();
        assertEquals(true, menuSettings.isSelectedBacktoMenu());
        menuSettings.nextEntry();
        assertEquals(true, menuSettings.isSelectedMusic());
        menuSettings.previousEntry();
        assertEquals(true, menuSettings.isSelected(2));
        assertEquals("Sound", menuSettings.getEntry(1));
        assertEquals(3,menuSettings.getNumberEntries());
    }

    @Test
    public void Sound(){
        menuSettings.setMutesound();
        assertEquals(false,menuSettings.getMuteSound());
        menuSettings.setMutemusic();
        assertEquals(false,menuSettings.getMuteMusic());
    }
}

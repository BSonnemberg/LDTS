package com.blm.dusk.model;

import com.blm.dusk.models.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void testInitialMenuState() {
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedSettings());
        assertFalse(menu.isSelectedExit());
    }

    @Test
    void testNextEntry() {
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        assertTrue(menu.isSelectedSettings());
        assertFalse(menu.isSelectedExit());

        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        assertFalse(menu.isSelectedSettings());
        assertTrue(menu.isSelectedExit());

        menu.nextEntry();
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedSettings());
        assertFalse(menu.isSelectedExit());
    }

    @Test
    void testPreviousEntry() {
        menu.previousEntry();
        assertFalse(menu.isSelectedStart());
        assertFalse(menu.isSelectedSettings());
        assertTrue(menu.isSelectedExit());

        menu.previousEntry();
        assertFalse(menu.isSelectedStart());
        assertTrue(menu.isSelectedSettings());
        assertFalse(menu.isSelectedExit());

        menu.previousEntry();
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedSettings());
        assertFalse(menu.isSelectedExit());
    }

    @Test
    void testGetEntry() {
        assertEquals("Start Game", menu.getEntry(0));
        assertEquals("Settings", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(3, menu.getNumberEntries());
    }
}

package com.blm.dusk.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;

public class LanternaGUITest {

    private LanternaGUI lanternaGUI;

    @BeforeEach
    public void setUp() {
        try {
            lanternaGUI = new LanternaGUI(80, 24);
        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInitialization() {
        Assertions.assertNotNull(lanternaGUI);
    }

    @Test
    public void testClearScreen() {
        Assertions.assertDoesNotThrow(() -> lanternaGUI.clearScreen());
    }

    @Test
    public void testRefresh() {
        Assertions.assertDoesNotThrow(() -> lanternaGUI.refresh());
    }

    @Test
    public void testGetAction() {
        Assertions.assertDoesNotThrow(() -> lanternaGUI.getAction());
    }

    @Test
    public void testClose() {
        Assertions.assertDoesNotThrow(() -> lanternaGUI.close());
    }
}

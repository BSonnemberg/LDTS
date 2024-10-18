package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Key;
import com.blm.dusk.view.game.KeyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class KeyViewerTest {

    private Key key;
    private KeyViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        key = new Key(5, 5);
        viewer = new KeyViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(key, gui);
        Mockito.verify(gui, Mockito.times(1)).drawKey(key.getPosition());
    }
}

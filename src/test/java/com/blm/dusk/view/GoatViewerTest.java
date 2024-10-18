package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Goat;
import com.blm.dusk.view.game.GoatViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GoatViewerTest {

    private Goat goat;
    private GoatViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        goat = new Goat(5, 5);
        viewer = new GoatViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(goat, gui);
        Mockito.verify(gui, Mockito.times(1)).drawGoat(goat.getPosition());
    }
}

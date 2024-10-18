package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Intruder;
import com.blm.dusk.view.game.IntruderViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IntruderViewerTest {

        private Intruder intruder;
        private IntruderViewer viewer;
        private LanternaGUI gui;

        @BeforeEach
        void BeforeEach() {
            intruder = new Intruder(10, 10);
            viewer = new IntruderViewer();
            gui = Mockito.mock(LanternaGUI.class);
        }

        @Test
        void drawElement() {
            viewer.draw(intruder, gui);
            Mockito.verify(gui, Mockito.times(1)).drawIntruder(intruder.getPosition());
        }

        @Test
        void drawElement_NotCalled() {
        Mockito.verify(gui, Mockito.never()).drawIntruder(intruder.getPosition());
        }

}

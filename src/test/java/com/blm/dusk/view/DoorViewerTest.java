package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Door;
import com.blm.dusk.view.game.DoorViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DoorViewerTest {

    private Door door;
    private DoorViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        door = new Door(5, 5);
        viewer = new DoorViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(door, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDoor(door.getPosition());
    }
}

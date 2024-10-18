package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Point;
import com.blm.dusk.view.game.PointViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PointViewerTest {

    private Point point;
    private PointViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        point = new Point(5, 5);
        viewer = new PointViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(point, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPoint(point.getPosition());
    }
}

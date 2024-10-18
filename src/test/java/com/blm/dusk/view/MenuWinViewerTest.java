package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuWin;
import com.blm.dusk.view.menu.MenuWinViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuWinViewerTest {

    private MenuWin menuWin;
    private MenuWinViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        menuWin = new MenuWin();
        viewer = new MenuWinViewer(menuWin);
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawMenuWin() {
        viewer.drawElements(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(13, 5), "WIN", "#00FF00");

        for (int i = 0; i < menuWin.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(
                    new Position(10, 8 + i),
                    menuWin.getEntry(i),
                    menuWin.isSelected(i) ? "#FFD700" : "#FFFFFF"
            );
        }
    }
}

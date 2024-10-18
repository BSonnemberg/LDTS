package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuLose;
import com.blm.dusk.view.menu.MenuLoseViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class MenuLoseViewerTest {
    private MenuLose menuLose;
    private MenuLoseViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        menuLose = new MenuLose();
        viewer = new MenuLoseViewer(menuLose);
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawMenuLose() {
        viewer.drawElements(gui);

        Mockito.verify(gui, times(1)).drawText(
                Mockito.eq(new Position(11, 5)),
                Mockito.eq("GAME OVER"),
                Mockito.eq("#FF0000"));

        for (int i = 0; i < menuLose.getNumberEntries(); i++) {
            Mockito.verify(gui, times(1)).drawText(
                    Mockito.eq(new Position(11, 8 + i)),
                    Mockito.eq(menuLose.getEntry(i)),
                    Mockito.eq(menuLose.isSelected(i) ? "#FFD700" : "#FFFFFF"));
        }
    }
}

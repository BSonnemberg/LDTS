package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuEndGame;
import com.blm.dusk.view.menu.MenuEndGameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class MenuEndGameViewerTest {
    private MenuEndGame menuEndGame;
    private MenuEndGameViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        menuEndGame = new MenuEndGame();
        viewer = new MenuEndGameViewer(menuEndGame);
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawMenuEndGame() {
        viewer.drawElements(gui);

        Mockito.verify(gui, times(1)).drawText(
                Mockito.eq(new Position(8, 5)),
                Mockito.eq("YOU WON THE GAME"),
                Mockito.eq("#00FF00"));

        for (int i = 0; i < menuEndGame.getNumberEntries(); i++) {
            Mockito.verify(gui, times(1)).drawText(
                    Mockito.eq(new Position(10, 7 + i)),
                    Mockito.eq(menuEndGame.getEntry(i)),
                    Mockito.eq(menuEndGame.isSelected(i) ? "#FFD700" : "#FFFFFF"));
        }
    }
}

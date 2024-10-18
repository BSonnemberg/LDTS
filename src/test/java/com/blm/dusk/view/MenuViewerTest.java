package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.view.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class MenuViewerTest {
    private Menu menu;
    private MenuViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        menu = new Menu();
        viewer = new MenuViewer(menu);
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawMenu() {
        viewer.drawElements(gui);

        Mockito.verify(gui, times(1)).drawText(Mockito.eq(new Position(13, 5)), Mockito.eq("Menu"), Mockito.eq("#FFFFFF"));

        for (int i = 0; i < menu.getNumberEntries(); i++) {
            Mockito.verify(gui, times(1)).drawText(
                    Mockito.eq(new Position(10, 7 + i)),
                    Mockito.eq(menu.getEntry(i)),
                    Mockito.eq(menu.isSelected(i) ? "#FFD700" : "#FFFFFF"));
        }
    }
}

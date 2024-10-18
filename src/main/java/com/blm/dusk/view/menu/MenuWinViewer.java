package com.blm.dusk.view.menu;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuWin;
import com.blm.dusk.view.Viewer;

public class MenuWinViewer extends Viewer<MenuWin> {
    public MenuWinViewer(MenuWin menuWin) {
        super(menuWin);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(13, 5), "WIN", "#00FF00");



        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

package com.blm.dusk.view.menu;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuLose;
import com.blm.dusk.view.Viewer;

public class MenuLoseViewer extends Viewer<MenuLose> {
    public MenuLoseViewer(MenuLose menulose) {
        super(menulose);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        gui.drawText(new Position(11, 5), "GAME OVER", "#FF0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(11, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

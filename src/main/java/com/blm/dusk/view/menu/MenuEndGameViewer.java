package com.blm.dusk.view.menu;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuEndGame;
import com.blm.dusk.view.Viewer;

public class MenuEndGameViewer extends Viewer<MenuEndGame> {
    public MenuEndGameViewer(MenuEndGame menuEnd) {
        super(menuEnd);
    }

    @Override
    public void drawElements(LanternaGUI gui){

        gui.drawText(new Position(8, 5), "YOU WON THE GAME", "#00FF00");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
}

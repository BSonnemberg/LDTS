package com.blm.dusk.view.menu;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.view.Viewer;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu){
        super(menu);
    }

    @Override
    public void drawElements(LanternaGUI gui){
        gui.drawText(new Position(13, 5), "Menu","#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }

}

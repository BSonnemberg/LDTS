package com.blm.dusk.view.menu;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.menu.MenuSettings;

import com.blm.dusk.view.Viewer;

public class MenuSettingsViewer extends Viewer<MenuSettings> {
    public MenuSettingsViewer(MenuSettings menuSettings){super(menuSettings);}

    @Override
    protected void drawElements(LanternaGUI gui) {

        for (int i = 0; i < getModel().getNumberEntries(); i++){
            if (getModel().isSelected(i)) gui.drawText(new Position(29, 5+i),"","#FFD700");
            gui.drawText(new Position(9, 5+i),  getModel().getEntry(i) , getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
        gui.drawText(new Position(19 , 5),  getModel().getMuteMusic()? "OFF":"ON"  , getModel().isSelectedMusic() ? "#FFD700" : "#FFFFFF");
        gui.drawText(new Position(19 , 6),  getModel().getMuteSound()?  "OFF":"ON" , getModel().isSelectedSound() ? "#FFD700" : "#FFFFFF");


    }
}

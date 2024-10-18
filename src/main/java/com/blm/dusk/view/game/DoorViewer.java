package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Door;

public class DoorViewer implements ElementViewer<Door>{
        @Override
        public void draw(Door door, LanternaGUI gui){gui.drawDoor(door.getPosition());}

}


package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Intruder;

public class IntruderViewer implements ElementViewer<Intruder>{
    @Override
    public void draw(Intruder intruder, LanternaGUI gui){
        gui.drawIntruder(intruder.getPosition());
    }

}

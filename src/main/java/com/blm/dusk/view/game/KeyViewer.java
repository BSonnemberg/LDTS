package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Key;

public class KeyViewer implements ElementViewer<Key>{
    @Override
    public void draw(Key key, LanternaGUI gui){gui.drawKey(key.getPosition());}

}


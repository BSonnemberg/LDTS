package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Goat;

public class GoatViewer implements ElementViewer<Goat> {
    @Override
    public void draw(Goat goat, LanternaGUI gui) {
        gui.drawGoat(goat.getPosition());
    }
}

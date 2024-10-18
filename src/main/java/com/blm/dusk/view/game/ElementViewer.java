package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, LanternaGUI gui);

}

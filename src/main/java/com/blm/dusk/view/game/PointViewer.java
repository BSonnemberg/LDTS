package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Point;

public class PointViewer implements ElementViewer<Point>{
@Override
    public void draw(Point p, LanternaGUI gui){gui.drawPoint(p.getPosition());}

}

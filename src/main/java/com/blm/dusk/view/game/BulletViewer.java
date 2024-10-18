package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet>{
    @Override
    public void draw(Bullet bullet, LanternaGUI gui){gui.drawBullet(bullet.getPosition());}
}

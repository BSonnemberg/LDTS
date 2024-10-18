package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Bullet;
import com.blm.dusk.view.game.BulletViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BulletViewerTest {

    private Bullet bullet;
    private BulletViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        bullet = new Bullet(5, 5);
        viewer = new BulletViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(bullet, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBullet(bullet.getPosition());
    }
}

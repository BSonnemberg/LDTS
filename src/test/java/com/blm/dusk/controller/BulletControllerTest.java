package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.game.BulletController;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.Bullet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BulletControllerTest {
    private BulletController controller;
    private Arena arena;
    private Application application;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10, true);
        List<Bullet> bullets = new ArrayList<>();
        arena.setBullet(bullets);

        controller = new BulletController(arena);
        application = mock(Application.class);
    }

    @Test
    void step_ShootUp_AddBulletToList() throws IOException {
        controller.step(application, LanternaGUI.ACTION.SHOOTUP, 100);
        assertEquals(1, arena.getBullet().size());
    }

    @Test
    void step_ShootRight_NoBulletAdded() throws IOException {
        controller.step(application, LanternaGUI.ACTION.SHOOTRIGHT, 100);
        assertEquals(1, arena.getBullet().size());
    }
}

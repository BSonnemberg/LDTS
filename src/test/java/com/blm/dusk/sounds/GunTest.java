package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class GunTest {

    private Gun gun;

    @BeforeEach
    public void setUp() {
        gun = new Gun();
    }

    @Test
    public void testPlay() {
        Assertions.assertDoesNotThrow(() -> gun.play());
    }

    @Test
    public void testStop() {
        Assertions.assertDoesNotThrow(() -> {
            gun.play();
            Clip clip = gun.getClip();
            gun.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }

}

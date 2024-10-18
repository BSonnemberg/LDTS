package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class HitGoatTest {

    private HitGoat hitGoat;

    @BeforeEach
    public void setUp() {
        hitGoat = new HitGoat();
    }

    @Test
    public void testPlay() {
        Assertions.assertDoesNotThrow(() -> hitGoat.play());
    }

    @Test
    public void testStop() {
        Assertions.assertDoesNotThrow(() -> {
            hitGoat.play();
            Clip clip = hitGoat.getClip();
            hitGoat.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }

}

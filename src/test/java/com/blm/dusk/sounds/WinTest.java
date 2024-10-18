package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class WinTest {

    private Win winSound;

    @BeforeEach
    public void setUp() {
        winSound = new Win();
    }

    @Test
    public void testPlay() {

        Assertions.assertDoesNotThrow(() -> winSound.play());
    }

    @Test
    public void testStop() {

        Assertions.assertDoesNotThrow(() -> {
            winSound.play();
            Clip clip = winSound.getClip();
            winSound.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }
}

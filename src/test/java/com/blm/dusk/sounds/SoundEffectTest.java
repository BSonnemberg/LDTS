package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class SoundEffectTest {

    private SoundEffect soundEffect;

    @BeforeEach
    public void setUp() {
        soundEffect = new SoundEffect("Sounds/game.wav");
    }


    @Test
    public void testPlay() {
        Assertions.assertDoesNotThrow(() -> soundEffect.play());
    }


    @Test
    public void testStop() {

        Assertions.assertDoesNotThrow(() -> {
            soundEffect.play();
            Clip clip = soundEffect.getClip();
            soundEffect.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }


}

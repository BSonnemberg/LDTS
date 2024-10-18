package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class MenuMusicTest {

    private MenuMusic menuMusic;

    @BeforeEach
    public void setUp() {
        menuMusic = new MenuMusic();
    }

    @Test
    public void testPlay() {
        Assertions.assertDoesNotThrow(() -> menuMusic.play());
    }

    @Test
    public void testStop() {
        Assertions.assertDoesNotThrow(() -> {
            menuMusic.play();
            Clip clip = menuMusic.getClip();
            menuMusic.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }
}

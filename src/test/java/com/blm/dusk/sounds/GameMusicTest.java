package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class GameMusicTest {

    private GameMusic gameMusic;

    @BeforeEach
    public void setUp() {
        gameMusic = new GameMusic();
    }

    @Test
    public void testPlay() {

        Assertions.assertDoesNotThrow(() -> gameMusic.play());
    }

    @Test
    public void testStop() {

        Assertions.assertDoesNotThrow(() -> {
            gameMusic.play();
            Clip clip = gameMusic.getClip();
            gameMusic.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }
}

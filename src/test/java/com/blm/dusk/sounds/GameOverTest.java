package com.blm.dusk.sounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sound.sampled.Clip;

public class GameOverTest {

    private GameOver gameOver;

    @BeforeEach
    public void setUp() {
        gameOver = new GameOver();
    }

    @Test
    public void testPlay() {
        Assertions.assertDoesNotThrow(() -> gameOver.play());
    }

    @Test
    public void testStop() {

        Assertions.assertDoesNotThrow(() -> {
            gameOver.play();
            Clip clip = gameOver.getClip();
            gameOver.stop();
            Assertions.assertFalse(clip.isRunning());
        });
    }


}

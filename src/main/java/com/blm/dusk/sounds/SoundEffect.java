package com.blm.dusk.sounds;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SoundEffect {
    protected final String soundFile;
    protected Clip clip;
    protected boolean playSound = true, playMusic = true;

    public SoundEffect(String soundFile){
        this.soundFile=soundFile;
    }

    public void play(){
        if(playSound){
            try {
                {
                    URL resource = getClass().getClassLoader().getResource(this.soundFile);
                    File musicaFile = new File(resource.toURI());
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicaFile.toURI()));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                }
            } catch (UnsupportedAudioFileException | LineUnavailableException | URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        if (clip != null)
            clip.stop();
    }

    public Clip getClip() {
        return clip;
    }
}

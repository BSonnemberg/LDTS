package com.blm.dusk.sounds;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MenuMusic extends SoundEffect{
    public MenuMusic(){
        super("Sounds/menu.wav");
    }

    @Override
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
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } catch (UnsupportedAudioFileException | LineUnavailableException | URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void stop() {
        if (clip != null)
            clip.stop();
    }


}
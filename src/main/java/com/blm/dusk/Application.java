package com.blm.dusk;


import com.blm.dusk.sounds.GameMusic;
import com.blm.dusk.sounds.GameOver;
import com.blm.dusk.sounds.MenuMusic;
import com.blm.dusk.sounds.Win;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.state.*;

import java.awt.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;
    private GameMusic gameMusic;
    private MenuMusic menuMusic;
    private GameOver gameOver;
    private Win win;
    private int level = 1;
    protected static boolean Sound=true,Music=true;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(32, 14);
        this.state = new MenuState(new Menu());
        this.gameMusic = new GameMusic();
        this.menuMusic= new MenuMusic();
        this.gameOver = new GameOver();
        this.win = new Win();
    }

    public int getLevel() { return level; }
    public int nextLevel() { return ++level; }
    public void resetLevel(){level=1;}

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Application().start();
    }

    public void setState(State state) {
        if (Music) {
            music(state);
        }
        this.state = state;
    }

    public State getState() { return this.state; }

    private void start() throws IOException {
        int FPS = 120;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new InterruptedIOException("Game can't start!");
            }
        }

        gui.close();
    }
    public boolean getplayMusic(){
        return Music;
    }
    public boolean getplaySound(){
        return Sound;
    }

    public void setplayMusic(){
        Music=!Music;
    }

    public void setplaySound(){
        Sound=!Sound;
    }

    private void  music(State state){
        if (state instanceof MenuState){
            gameMusic.stop();
            menuMusic.play();

        }
        if(state instanceof GameState){
            gameMusic.play();
            menuMusic.stop();


        }
        if(state instanceof MenuWinState){
            gameMusic.stop();
            win.play();



        }
        if(state instanceof MenuLoseState){
            gameMusic.stop();
            gameOver.play();



        }
        if(state instanceof MenuEndGameState){
            gameMusic.stop();

        }

        if(state instanceof MenuSettingsState){
            menuMusic.stop();
            gameMusic.stop();
        }


    }



}


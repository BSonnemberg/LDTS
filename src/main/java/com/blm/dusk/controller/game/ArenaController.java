package com.blm.dusk.controller.game;

import com.blm.dusk.Application;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuEndGame;
import com.blm.dusk.models.menu.MenuLose;
import com.blm.dusk.models.menu.MenuWin;
import com.blm.dusk.state.MenuEndGameState;
import com.blm.dusk.state.MenuLoseState;
import com.blm.dusk.state.MenuState;
import com.blm.dusk.state.MenuWinState;

import java.io.IOException;

public class ArenaController extends GameController{
    private final IntruderController intruderController;
    private final GoatController goatController;
    private final BulletController bulletController;

    private static final int NUM_LEVELS = 4;

    public ArenaController(Arena arena){
        super(arena);
        this.intruderController = new IntruderController(arena);
        this.goatController = new GoatController(arena);
        this.bulletController= new BulletController(arena);
    }


    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) throws IOException {
        if( getModel().getIntruder().getMovesAvailable()==0){
            application.resetLevel();
            application.setState(new MenuLoseState(new MenuLose()));
        }


        if(getModel().getIntruder().getNextLevel()){

            if(application.getLevel()>=NUM_LEVELS){application.setState(new MenuEndGameState(new MenuEndGame()));}
            else application.setState(new MenuWinState(new MenuWin()));

        }


        else if(action == LanternaGUI.ACTION.QUIT ){
            application.setState(new MenuState(new Menu()));
        }

        intruderController.step(application,action,time);
        goatController.step(application,action,time);
        bulletController.step(application,action,time);
    }
}


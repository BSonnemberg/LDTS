package com.blm.dusk.controller.menu;

import com.blm.dusk.Application;
import com.blm.dusk.controller.Controller;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.arena.ArenaGenerator;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuLose;
import com.blm.dusk.state.GameState;
import com.blm.dusk.state.MenuState;

import java.io.IOException;

public class MenuLoseController extends Controller<MenuLose> {
    public MenuLoseController(MenuLose menuLose) {
        super(menuLose);
    }

    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) throws IOException {

        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedBackMenu()) application.setState(new MenuState(new Menu()));
                if (getModel().isSelectedPlayAgain()) application.setState(new GameState(new ArenaGenerator(getModel().getCurrentLevel(),application.getplaySound()).createArena(application.getplaySound())));
                break;
            default:
                break;
        }
    }

}

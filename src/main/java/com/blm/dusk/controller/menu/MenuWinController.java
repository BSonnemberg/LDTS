package com.blm.dusk.controller.menu;

import com.blm.dusk.Application;
import com.blm.dusk.controller.Controller;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.arena.ArenaGenerator;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuWin;
import com.blm.dusk.state.GameState;
import com.blm.dusk.state.MenuState;

import java.io.IOException;


public class MenuWinController extends Controller<MenuWin> {

    public MenuWinController(MenuWin menuWin) {
        super(menuWin);
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
                    if (getModel().isSelectedNextLevel()) application.setState(new GameState(new ArenaGenerator(application.nextLevel(), application.getplaySound()).createArena(application.getplaySound())));
                    break;
            default:
                break;
        }
    }
}

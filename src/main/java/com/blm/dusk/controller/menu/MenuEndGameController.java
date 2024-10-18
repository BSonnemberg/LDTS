package com.blm.dusk.controller.menu;

import com.blm.dusk.Application;
import com.blm.dusk.controller.Controller;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuEndGame;
import com.blm.dusk.state.MenuState;

public class MenuEndGameController extends Controller<MenuEndGame> {
    public MenuEndGameController(MenuEndGame menuEnd) {
        super(menuEnd);
    }

    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) {

        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) application.setState(null);
                if (getModel().isSelectedBackMenu()) application.setState(new MenuState(new Menu()));
                break;
            default:
                break;
        }
    }
}

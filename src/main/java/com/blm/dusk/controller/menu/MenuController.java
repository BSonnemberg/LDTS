package com.blm.dusk.controller.menu;

import com.blm.dusk.Application;
import com.blm.dusk.controller.Controller;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.arena.ArenaGenerator;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuSettings;
import com.blm.dusk.state.GameState;
import com.blm.dusk.state.MenuSettingsState;

import java.io.IOException;


public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) application.setState(null);
                if(getModel().isSelectedSettings()) application.setState(new MenuSettingsState(new MenuSettings(application.getplayMusic(), application.getplaySound())));
                if (getModel().isSelectedStart()) application.setState(new GameState(new ArenaGenerator(1,application.getplaySound()).createArena(application.getplaySound())));
                break;
            default:
                break;
        }
    }
}

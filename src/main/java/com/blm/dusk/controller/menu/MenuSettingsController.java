package com.blm.dusk.controller.menu;

import com.blm.dusk.Application;
import com.blm.dusk.controller.Controller;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.models.menu.MenuSettings;

import com.blm.dusk.state.MenuState;

import java.io.IOException;

public class MenuSettingsController extends Controller<MenuSettings> {
    public MenuSettingsController(MenuSettings menuSettings) { super(menuSettings);}

    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) throws IOException {
        switch (action){
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();;
                break;
            case SELECT:
                if(getModel().isSelectedBacktoMenu()) {
                    application.setState(new MenuState(new Menu()));
                    break;
                }
                if(getModel().isSelectedMusic()){
                    application.setplayMusic();
                    getModel().setMutemusic();
                }
                else if(getModel().isSelectedSound()){
                    application.setplaySound();
                    getModel().setMutesound();
                }
                break;
            default:break;
        }
    }
}

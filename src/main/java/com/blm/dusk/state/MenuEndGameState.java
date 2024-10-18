package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.menu.MenuEndGameController;
import com.blm.dusk.models.menu.MenuEndGame;
import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.menu.MenuEndGameViewer;

public class MenuEndGameState extends State<MenuEndGame>{
    public MenuEndGameState(MenuEndGame menuEnd){
        super(menuEnd);
    }

    @Override
    protected Viewer<MenuEndGame> getViewer() {
        return new MenuEndGameViewer(getModel());
    }

    @Override
    protected Controller<MenuEndGame> getController() {
        return new MenuEndGameController(getModel());
    }
}

package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.menu.MenuWinController;
import com.blm.dusk.models.menu.MenuWin;
import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.menu.MenuWinViewer;

public class MenuWinState extends State<MenuWin>{
    public MenuWinState(MenuWin menuWin) {
        super(menuWin);
    }

    @Override
    protected Viewer<MenuWin> getViewer() {
        return new MenuWinViewer(getModel());
    }

    @Override
    protected Controller<MenuWin> getController() {
        return new MenuWinController(getModel());
    }
}

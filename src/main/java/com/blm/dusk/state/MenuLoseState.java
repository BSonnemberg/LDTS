package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.menu.MenuLoseController;
import com.blm.dusk.models.menu.MenuLose;
import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.menu.MenuLoseViewer;

public class MenuLoseState extends State<MenuLose>{
    public MenuLoseState(MenuLose menuLose){
        super(menuLose);
    }

    @Override
    protected Viewer<MenuLose> getViewer() {
        return new MenuLoseViewer(getModel());
    }

    @Override
    protected Controller<MenuLose> getController() {
        return new MenuLoseController(getModel());
    }
}

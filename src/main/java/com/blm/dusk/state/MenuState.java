package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.menu.MenuController;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.menu.MenuViewer;

public class MenuState extends State<Menu> {

    public MenuState(Menu model){
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}

package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.menu.MenuSettingsController;
import com.blm.dusk.models.menu.MenuSettings;

import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.menu.MenuSettingsViewer;

public class MenuSettingsState extends State<MenuSettings> {
    public MenuSettingsState(MenuSettings menuSettings) {super(menuSettings);}

    @Override
    protected Viewer<MenuSettings> getViewer() {
        return new MenuSettingsViewer(getModel());
    }

    @Override
    protected Controller<MenuSettings> getController() {
        return new MenuSettingsController(getModel());
    }
}

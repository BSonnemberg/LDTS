package com.blm.dusk.state;

import com.blm.dusk.Application;
import com.blm.dusk.controller.Controller;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.view.Viewer;

import java.io.IOException;

public abstract class State<T> {

    private final T model;
    private final Controller<T> controller;

    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Application application, LanternaGUI gui, long time) throws IOException {
        LanternaGUI.ACTION action = gui.getAction();
        controller.step(application, action, time);
        viewer.draw(gui);

    }

}

package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;

import java.io.IOException;

public abstract class Viewer<T>{
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(LanternaGUI gui) throws IOException {
        gui.clearScreen();
        drawElements(gui);
        gui.refresh();
    }
    protected abstract void drawElements(LanternaGUI gui);
}


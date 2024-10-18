package com.blm.dusk.controller;
import com.blm.dusk.Application;
import com.blm.dusk.gui.LanternaGUI;

import java.io.IOException;


public abstract class Controller<T>{
    private T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }
    public abstract void step(Application application, LanternaGUI.ACTION action, long time) throws IOException;
}

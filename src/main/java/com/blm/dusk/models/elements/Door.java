package com.blm.dusk.models.elements;

public class Door extends Element{

    public boolean open;
    public Door(int x, int y) {
        super(x, y);
        open=false;
    }

    public void open(){
        open=true;
    }
}

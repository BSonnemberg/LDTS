package com.blm.dusk.models.elements;

public class Key extends Element{

    private boolean collected;
    public Key(int x, int y) {
        super(x, y);
        collected=false;
    }
    public void collectedKey(){
        collected=true;
    }

    public boolean getCollected(){
        return collected;
    }


}

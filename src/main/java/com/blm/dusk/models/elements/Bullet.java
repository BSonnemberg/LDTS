package com.blm.dusk.models.elements;

public class Bullet extends Element{
    private String direction;
    public Bullet(int x, int y){
        super(x, y);
    }
    public void setDirection(String direction){
        this.direction=direction;
    }
    public String getDirection(){
        return this.direction;

    }
}

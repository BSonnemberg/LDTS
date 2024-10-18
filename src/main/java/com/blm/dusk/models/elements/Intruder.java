package com.blm.dusk.models.elements;

public class Intruder extends Element{

    private int movesAvailable;
    private boolean nextLevel;
    public boolean key;

    public Intruder(int x, int y){
        super(x, y);
        this.movesAvailable = 50;
        this.nextLevel = false;
        key=false;
    }

    public void decreaseMoves() {this.movesAvailable--;}

    public int getMovesAvailable() {return this.movesAvailable;}

    public void setMovestoZero(){this.movesAvailable=0;}

    public void addMoves(int moves) { this.movesAvailable += moves; }

    public boolean hasKey(){return key;}

    public void getKey(){key=true;}

    public void setNextLevelTrue(){
        this.nextLevel=true;
    }

    public boolean getNextLevel(){
        return nextLevel;
    }
}


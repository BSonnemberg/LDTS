package com.blm.dusk.models;

public class Position {
    private final int x;
    private final int y;



    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Position getLeft(){
        return new Position(x-1,y);
    }

    public Position getRight(){
        return new Position(x+1,y);
    }

    public Position getUp(){
        return new Position(x,y-1);
    }

    public Position getDown(){
        return new Position(x, y+1);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 89 * hash + x;
        hash = 89 * hash +y;
        return hash;
    }

    public Position getRandomNeighbour() {
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                return getUp();

            case 1:
                return getRight();

            case 2:
                return getDown();

            default:
                return getLeft();
        }
    }
}

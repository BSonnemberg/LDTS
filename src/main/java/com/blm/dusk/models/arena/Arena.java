package com.blm.dusk.models.arena;

import com.blm.dusk.models.Position;
import com.blm.dusk.models.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final int height;
    private final int width;
    private List<Block> blockslist;
    private Intruder intruder;
    private List<Goat> goats;
    private List<Tree> trees;
    private com.blm.dusk.models.elements.Key key;
    private Door door;
    private List<Point> points;
    private List<Bullet> bullets;

    public Arena(int width, int height, boolean a) {
        this.height = height;
        this.width = width;
        intruder = new Intruder(10, 10);


    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Intruder getIntruder() {
        return intruder;
    }

    public void setIntruder (Intruder intruder) {
        this.intruder = intruder;
    }

    public List<Goat> getGoats() {
        return goats;
    }

    public void setGoats(List<Goat> goats) {
        this.goats = goats;
    }

    public List<Block> getBlockslist() {
        return blockslist;
    }

    public void setBlockslist(List<Block> blockslist) {
        this.blockslist = blockslist;
    }

    public void setTrees(List<Tree> trees){this.trees = trees;}
    public List<Tree> getTrees() {return trees;}

    public void setKey(Key key){this.key = key;}
    public Key getKey() {return key;};

    public void setDoor(Door door){this.door = door;}
    public Door getDoor() {return door;}

    public void setBullet(List<Bullet> bullets) { this.bullets = bullets; }

    public List<Bullet> getBullet() {return bullets;}

    public List<Point> getPoints() { return this.points; }
    public void setPoints(List<Point> points) { this.points = points; }


  public Intruder createIntruder(int x, int y) {
      intruder = new Intruder(x, y);
      return intruder;
   }
 public List<Block> createBlocks() {
      if (blockslist == null) {
            blockslist = new ArrayList<>();
      } else {
         blockslist.clear();
        }


        for (int x = 0; x < width; x++) {
            blockslist.add(new Block(x, 0));
            blockslist.add(new Block(x, height - 1));
        }
        for (int y = 0; y < height; y++) {
            blockslist.add(new Block(0, y));
            blockslist.add(new Block(width - 1, y));
      }
       return blockslist;
   }

    public List<Goat> createGoats() {
       Random random = new Random();
        if (goats == null) {
            goats = new ArrayList<>();
        } else {
            goats.clear();
        }

        while (goats.size() < 4) {
           int goatX = random.nextInt(width - 2) + 1;
            int goatY = random.nextInt(height - 2) + 1;


            if (!isBlockAtPosition(goatX, goatY) && !isIntruderAtPosition(goatX, goatY)) {
                Goat newGoat = new Goat(goatX, goatY);
               goats.add(newGoat);
            }
        }
        return goats;
    }

    public boolean isBlockAtPosition(int x, int y) {
        if (blockslist != null) {
            for (Block block : blockslist) {
                if (block.getPosition().getX() == x && block.getPosition().getY() == y) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isIntruderAtPosition(int x, int y) {
        if (intruder != null) {
            return intruder.getPosition().getX() == x && intruder.getPosition().getY() == y;
        }
        return false;
    }

    public Arena createArena(boolean a) {
        Arena arena = new Arena(getWidth(), getHeight(),a);
        arena.setIntruder(createIntruder(10, 10));
        arena.setBlockslist(createBlocks());
        arena.setGoats(createGoats());
        return arena;
    }

    public boolean isEmpty(Position position) {
        for (Block block : blockslist) {
            if (block.getPosition().equals(position)) {
                return false;
            }
        }
        for(Tree tree: trees){
            if (tree.getPosition().equals(position)){
                return false;
            }
        }
        if(door!=null){
            if(door.getPosition().equals(position) && !intruder.hasKey()) {
                return false;
            }
        }

        return true;
    }

    public boolean isGoat(Position position){
        for (Goat goat: goats){
            if (goat.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public boolean isKey(Position position){
        if(key.getPosition().equals(position)){
            return true;
        }
        return false;
    }

    public void grabKey() {
        if(key!=null && intruder.getPosition().equals(key.getPosition())){
            key.collectedKey();
            intruder.getKey();
        }
    }

    public boolean isDoorOpen(Position position){
        if(key.getCollected() ){
            return true;
        }
        return false;
    }

    public boolean isPoint(Position position) {
        for (Point p : points){
            if (p.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
}




package com.blm.dusk.controller.game;

import com.blm.dusk.Application;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.Goat;
import com.blm.dusk.models.elements.Point;
import com.blm.dusk.models.elements.Tree;

import java.io.IOException;

public class GoatController extends GameController{
    private long lastMovement;



    public GoatController(Arena arena) {
        super(arena);
        this.lastMovement=0;


    }

    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) throws IOException {
        if(time -lastMovement>500){
            for(Goat goat: getModel().getGoats()){
                Position newPos;
                while (true) {
                    newPos = goat.getPosition().getRandomNeighbour();
                    if (isMoveValid(getModel(), newPos)) break;
                }
                moveGoat(goat, newPos);
                this.lastMovement=time;
            }
        }
    }

    private boolean isMoveValid(Arena a, Position pos) {
        if (a.getKey().getPosition().equals(pos)) return false;
        if (a.getDoor().getPosition().equals(pos)) return false;
        for (Tree t : a.getTrees()) if (t.getPosition().equals(pos)) return false;
        for (Point p : a.getPoints()) if (p.getPosition().equals(pos)) return false;
        for (Goat g2 : a.getGoats()) if (g2.getPosition().equals(pos)) return false;
        return true;
    }

    private void moveGoat(Goat goat, Position position){
        if(getModel().isEmpty(position)){
            goat.setPosition(position);
            if (getModel().getIntruder().getPosition().equals(position)){
                getModel().getIntruder().setMovestoZero();
            }
        }
    }
}

package com.blm.dusk.controller.game;

import com.blm.dusk.Application;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.arena.Arena;

public class IntruderController extends GameController {


    public IntruderController (Arena arena){
        super(arena);

    }

    private void moveIntruder(Position position){
        if(getModel().isEmpty(position)){
            getModel().getIntruder().setPosition(position);
            getModel().getIntruder().decreaseMoves();
            if (getModel().isGoat(position)){
                getModel().getIntruder().setMovestoZero();
            }
            if(getModel().isKey(position)){
                getModel().grabKey();
                getModel().getKey().setPosition(new Position(20,-1));
            }
            if(getModel().isDoorOpen(position) && getModel().getIntruder().getPosition().equals(getModel().getDoor().getPosition())){
                getModel().getIntruder().setNextLevelTrue();

            }
            if (getModel().isPoint(position)) {
                getModel().getIntruder().addMoves(3);
                getModel().getPoints().removeIf(p -> p.getPosition().equals(position));
            }
            if(getModel().getIntruder().getMovesAvailable()==0){}
        }
    }

    public void moveIntruderLeft(){
        moveIntruder(getModel().getIntruder().getPosition().getLeft());
    }

    public void moveIntruderRight(){
        moveIntruder(getModel().getIntruder().getPosition().getRight());
    }

    public void moveIntruderUp(){
        moveIntruder(getModel().getIntruder().getPosition().getUp());
    }

    public void moveIntruderDown(){
        moveIntruder(getModel().getIntruder().getPosition().getDown());
    }

    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) {
        if(action==LanternaGUI.ACTION.UP) moveIntruderUp();
        if(action==LanternaGUI.ACTION.LEFT) moveIntruderLeft();
        if(action==LanternaGUI.ACTION.RIGHT) moveIntruderRight();
        if(action==LanternaGUI.ACTION.DOWN) moveIntruderDown();
    }
}

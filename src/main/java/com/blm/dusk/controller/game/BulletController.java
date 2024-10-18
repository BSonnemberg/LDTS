package com.blm.dusk.controller.game;

import com.blm.dusk.Application;
import com.blm.dusk.sounds.Gun;
import com.blm.dusk.sounds.SoundEffect;
import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.Block;
import com.blm.dusk.models.elements.Bullet;

import java.io.IOException;

public class BulletController extends GameController{
    private long lastMovement;

    private SoundEffect gun;
    public BulletController(Arena arena) {
        super(arena);
        gun = new Gun();
        this.lastMovement=0;
    }

    @Override
    public void step(Application application, LanternaGUI.ACTION action, long time) throws IOException {
        if(action==LanternaGUI.ACTION.SHOOTUP) {
            Bullet bullet = new Bullet(getModel().getIntruder().getPosition().getX(), getModel().getIntruder().getPosition().getY());
            bullet.setDirection("Up");
            getModel().getBullet().add(bullet);
            if(application.getplaySound()) gun.play();

        }
        if(action==LanternaGUI.ACTION.SHOOTLEFT) {
            Bullet bullet = new Bullet(getModel().getIntruder().getPosition().getX(), getModel().getIntruder().getPosition().getY());
            bullet.setDirection("Left");
            getModel().getBullet().add(bullet);
            if(application.getplaySound()) gun.play();

        }
        if(action==LanternaGUI.ACTION.SHOOTRIGHT){
            Bullet bullet = new Bullet(getModel().getIntruder().getPosition().getX(), getModel().getIntruder().getPosition().getY());
            bullet.setDirection("Right");
            getModel().getBullet().add(bullet);
            if(application.getplaySound()) gun.play();

        }
        if(action==LanternaGUI.ACTION.SHOOTDOWN) {
            Bullet bullet = new Bullet(getModel().getIntruder().getPosition().getX(), getModel().getIntruder().getPosition().getY());
            bullet.setDirection("Down");
            getModel().getBullet().add(bullet);
            if(application.getplaySound()) gun.play();
        }
        if(time -lastMovement>100){
            for(Bullet bullet: getModel().getBullet()){
                if(bullet.getDirection().equals("Up")) {moveBulletUp(bullet);}
                if(bullet.getDirection().equals("Down")) {moveBulletDown(bullet);}
                if(bullet.getDirection().equals("Right")) {moveBulletRight(bullet);}
                if(bullet.getDirection().equals("Left")) {moveBulletLeft(bullet);}

                this.lastMovement=time;
            }
        }
    }
    private void moveBullet(Bullet bullet, Position position){
        if(getModel().isEmpty(position)|| getModel().getDoor().getPosition().equals(position)){
            bullet.setPosition(position);
        }
        for(int i=0; i< getModel().getGoats().size();i++ ){
            if(getModel().getGoats().get(i).getPosition().equals(position)){

                getModel().getGoats().remove(i);
                bullet.setPosition(new Position(70,40));

            }
        }
        for(int i=0; i< getModel().getTrees().size();i++ ){
            if(getModel().getTrees().get(i).getPosition().equals(position)){
                getModel().getTrees().remove(i);
                bullet.setPosition(new Position(70,40));
            }
        }
        for(Block block: getModel().getBlockslist()){
            if(block.getPosition().equals(position)){
                bullet.setPosition(new Position(70,40));
            }
        }
    }

    public void moveBulletUp(Bullet bullet){
        moveBullet(bullet,bullet.getPosition().getUp());
    }
    public void moveBulletDown(Bullet bullet){
        moveBullet(bullet,bullet.getPosition().getDown());
    }
    public void moveBulletLeft(Bullet bullet){
        moveBullet(bullet,bullet.getPosition().getLeft());
    }
    public void moveBulletRight(Bullet bullet){moveBullet(bullet,bullet.getPosition().getRight());}
}

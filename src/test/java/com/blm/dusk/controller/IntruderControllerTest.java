package com.blm.dusk.controller;

import com.blm.dusk.controller.game.IntruderController;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntruderControllerTest {
    private IntruderController controller;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10, true);
        Intruder intruder = new Intruder(5, 5);
        arena.setIntruder(intruder);


        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(6, 5));
        arena.setBlockslist(blockList);


        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree(4, 4));
        arena.setTrees(trees);


        List<Goat> goats = new ArrayList<>();
        goats.add(new Goat(7, 5));
        arena.setGoats(goats);


        Key key = new Key(3, 5);
        arena.setKey(key);


        Door door = new Door(8, 8);
        arena.setDoor(door);


        List<Bullet> bullets = new ArrayList<>();
        bullets.add(new Bullet(2, 3));
        arena.setBullet(bullets);


        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        arena.setPoints(points);

        controller = new IntruderController(arena);
    }

    @Test
    void moveIntruderLeft_ValidMove() {
        controller.moveIntruderLeft();
        assertEquals(new Position(4, 5), arena.getIntruder().getPosition());
    }

    @Test
    void moveIntruderRight_ValidMove() {
        controller.moveIntruderRight();
        assertEquals(new Position(5, 5), arena.getIntruder().getPosition());
    }

    @Test
    void moveIntruderUp_ValidMove() {
        controller.moveIntruderUp();
        assertEquals(new Position(5, 4), arena.getIntruder().getPosition());
    }

    @Test
    void moveIntruderDown_ValidMove() {
        controller.moveIntruderDown();
        assertEquals(new Position(5, 6), arena.getIntruder().getPosition());
    }


}

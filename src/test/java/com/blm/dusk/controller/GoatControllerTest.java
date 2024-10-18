package com.blm.dusk.controller;

import com.blm.dusk.Application;
import com.blm.dusk.controller.game.GoatController;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GoatControllerTest {
    private GoatController controller;
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

        controller = new GoatController(arena);
    }

    @Test
    void moveGoat_ValidMove() throws IOException {
        Goat goat = new Goat(5, 5);
        arena.getGoats().add(goat);
        controller.step(mock(Application.class), null, 1000);


        Position initialPosition = new Position(5, 7);
        assertNotEquals(initialPosition, goat.getPosition());
    }
    @Test
    void moveGoat_IntruderInteraction() throws IOException {
        arena.getIntruder().setPosition(new Position(6, 6));


        for (int x = 5; x <= 7; x++) {
            for (int y = 5; y <= 7; y++) {
                if (x != 6 || y != 6) {
                    Goat goat = new Goat(x, y);
                    arena.getGoats().add(goat);
                }
            }
        }

        boolean goatReachedIntruder = false;
        int attempts = 100;


        for (int i = 0; i < attempts; i++) {
            controller.step(mock(Application.class), null, 1000);


            if (arena.getIntruder().getMovesAvailable() == 0) {
                goatReachedIntruder = true;
                break;
            }
        }


        assertTrue(goatReachedIntruder);
    }


}

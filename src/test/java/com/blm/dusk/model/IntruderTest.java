package com.blm.dusk.model;

import com.blm.dusk.models.Position;
import com.blm.dusk.models.elements.Intruder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntruderTest {
    private Intruder intruder;
    @BeforeEach
    public void setUp(){
        intruder = new Intruder(10,10);
    }

    @Test
    public void Position(){
        Position position =new Position(2,2);
        intruder.setPosition(position);
        assertEquals(2, intruder.getPosition().getY());
        assertEquals(2, intruder.getPosition().getX());

    }
}

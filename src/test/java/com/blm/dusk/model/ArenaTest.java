package com.blm.dusk.model;

import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ArenaTest{

    private Arena arena;

    @BeforeEach
    void beforeEach() {
        Arena arena= new Arena(10, 10, true);
    }


    @Test
    void testCreateBlocks() {
        Arena arena = new Arena(10, 10, true);
        List<Block> blocks = arena.createBlocks();

        assertNotNull(blocks, "Blocks list should not be null");

        assertFalse(blocks.isEmpty(), "Blocks list should not be empty");

        for (Block block : blocks) {
            int x = block.getPosition().getX();
            int y = block.getPosition().getY();

            boolean isAtBorder = x == 0 || x == 9 || y == 0 || y == 9;

            assertTrue(isAtBorder, "Block should be at the arena's border");
        }
    }
}

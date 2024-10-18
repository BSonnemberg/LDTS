package com.blm.dusk.model;

import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.arena.ArenaGenerator;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class ArenaGeneratorTest {

    @Test
    void testStage1Generation() {
        try {

            String arenaFilePath = "/stages/stage1.stage";
            Path path = Paths.get(getClass().getResource(arenaFilePath).toURI());
            String fileContent = Files.readString(path);


            ArenaGenerator arenaGenerator = new ArenaGenerator(1, true);
            Arena arena = arenaGenerator.createArena(true);

            assertNotNull(arena);


            assertEquals(31, arena.getWidth());
            assertEquals(13, arena.getHeight());



        } catch (IOException | URISyntaxException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}

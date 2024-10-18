package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.game.ArenaController;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.game.GameViewer;
import com.blm.dusk.state.GameState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {

    @Test
    void testGetViewer() {
        Arena arena = new Arena(20, 20, true);
        GameState gameState = new GameState(arena);

        Viewer<Arena> viewer = gameState.getViewer();

        assertTrue(viewer instanceof GameViewer);
        assertEquals(arena, ((GameViewer) viewer).getModel());
    }

    @Test
    void testGetController() {
        Arena arena = new Arena(20, 20, true);
        GameState gameState = new GameState(arena);

        Controller<Arena> controller = gameState.getController();

        assertTrue(controller instanceof ArenaController);
        assertEquals(arena, ((ArenaController) controller).getModel());
    }
}

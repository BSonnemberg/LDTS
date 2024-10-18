package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.models.menu.MenuEndGame;
import com.blm.dusk.view.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class MenuEndGameStateTest {

    private MenuEndGame menuEndGame;
    private MenuEndGameState menuEndGameState;

    @BeforeEach
    public void setUp() {
        menuEndGame = mock(MenuEndGame.class);
        menuEndGameState = new MenuEndGameState(menuEndGame);
    }

    @Test
    public void testGetViewer() {

        Assertions.assertNotNull(menuEndGameState.getViewer());
        Assertions.assertTrue(menuEndGameState.getViewer() instanceof Viewer);
    }

    @Test
    public void testGetController() {
        Assertions.assertNotNull(menuEndGameState.getController());
        Assertions.assertTrue(menuEndGameState.getController() instanceof Controller);
    }
}

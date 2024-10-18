package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.models.menu.MenuLose;
import com.blm.dusk.state.MenuLoseState;
import com.blm.dusk.view.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class MenuLoseStateTest {

    private MenuLose menuLose;
    private MenuLoseState menuLoseState;

    @BeforeEach
    public void setUp() {

        menuLose = mock(MenuLose.class);
        menuLoseState = new MenuLoseState(menuLose);
    }

    @Test
    public void testGetViewer() {

        Assertions.assertNotNull(menuLoseState.getViewer());
        Assertions.assertTrue(menuLoseState.getViewer() instanceof Viewer);
    }

    @Test
    public void testGetController() {

        Assertions.assertNotNull(menuLoseState.getController());
        Assertions.assertTrue(menuLoseState.getController() instanceof Controller);
    }
}

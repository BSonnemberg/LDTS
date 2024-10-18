package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.models.menu.MenuWin;
import com.blm.dusk.view.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class MenuWinStateTest {

    private MenuWin menuWinModel;
    private MenuWinState menuWinState;

    @BeforeEach
    public void setUp() {
        menuWinModel = mock(MenuWin.class);
        menuWinState = new MenuWinState(menuWinModel);
    }

    @Test
    public void testGetViewer() {
        Assertions.assertNotNull(menuWinState.getViewer());
        Assertions.assertTrue(menuWinState.getViewer() instanceof Viewer);
    }

    @Test
    public void testGetController() {
        Assertions.assertNotNull(menuWinState.getController());
        Assertions.assertTrue(menuWinState.getController() instanceof Controller);
    }
}

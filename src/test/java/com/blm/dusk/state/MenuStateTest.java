package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.models.menu.Menu;
import com.blm.dusk.view.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class MenuStateTest {

    private Menu menuModel;
    private MenuState menuState;

    @BeforeEach
    public void setUp() {
        menuModel = mock(Menu.class);
        menuState = new MenuState(menuModel);
    }

    @Test
    public void testGetViewer() {

        Assertions.assertNotNull(menuState.getViewer());
        Assertions.assertTrue(menuState.getViewer() instanceof Viewer);
    }

    @Test
    public void testGetController() {

        Assertions.assertNotNull(menuState.getController());
        Assertions.assertTrue(menuState.getController() instanceof Controller);
    }
}

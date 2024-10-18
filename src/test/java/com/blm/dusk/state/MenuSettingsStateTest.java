package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.models.menu.MenuSettings;
import com.blm.dusk.view.Viewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class MenuSettingsStateTest {

    private MenuSettings menuSettings;
    private MenuSettingsState menuSettingsState;

    @BeforeEach
    public void setUp() {
        menuSettings = mock(MenuSettings.class);
        menuSettingsState = new MenuSettingsState(menuSettings);
    }

    @Test
    public void testGetViewer() {

        Assertions.assertNotNull(menuSettingsState.getViewer());
        Assertions.assertTrue(menuSettingsState.getViewer() instanceof Viewer);
    }

    @Test
    public void testGetController() {

        Assertions.assertNotNull(menuSettingsState.getController());
        Assertions.assertTrue(menuSettingsState.getController() instanceof Controller);
    }
}

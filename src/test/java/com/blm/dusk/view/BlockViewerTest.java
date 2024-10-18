package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Block;
import com.blm.dusk.view.game.BlockViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BlockViewerTest {

    private Block block;
    private BlockViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        block = new Block(5, 5);
        viewer = new BlockViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(block, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBlock(block.getPosition());
    }
}

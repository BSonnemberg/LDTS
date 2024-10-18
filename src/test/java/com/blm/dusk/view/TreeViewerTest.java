package com.blm.dusk.view;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Tree;
import com.blm.dusk.view.game.TreeViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TreeViewerTest {

    private Tree tree;
    private TreeViewer viewer;
    private LanternaGUI gui;

    @BeforeEach
    void beforeEach() {
        tree = new Tree(5, 5);
        viewer = new TreeViewer();
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testDrawElement() {
        viewer.draw(tree, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTree(tree.getPosition());
    }
}
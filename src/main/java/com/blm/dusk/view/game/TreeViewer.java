package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Tree;

public class TreeViewer implements ElementViewer<Tree> {
        @Override
        public void draw(Tree tree, LanternaGUI gui) {gui.drawTree(tree.getPosition());}

}

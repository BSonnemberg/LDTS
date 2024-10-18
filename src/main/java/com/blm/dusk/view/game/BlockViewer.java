package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.elements.Block;

public class BlockViewer implements ElementViewer<Block> {
    @Override
    public void draw(Block block, LanternaGUI gui) {
        gui.drawBlock(block.getPosition());
    }
}

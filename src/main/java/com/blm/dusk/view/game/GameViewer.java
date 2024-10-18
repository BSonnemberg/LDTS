package com.blm.dusk.view.game;

import com.blm.dusk.gui.LanternaGUI;
import com.blm.dusk.models.Position;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.models.elements.Element;
import com.blm.dusk.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(LanternaGUI gui) {
        drawElements(gui,getModel().getPoints(), new PointViewer());
        drawElements(gui, getModel().getBlockslist(), new BlockViewer());
        drawElements(gui, getModel().getGoats(), new GoatViewer());
        drawElements(gui, getModel().getTrees(), new TreeViewer());
        drawElements(gui,getModel().getBullet(), new BulletViewer());
        drawElement(gui, getModel().getKey(), new KeyViewer());
        drawElement(gui, getModel().getDoor(), new DoorViewer());
        drawElement(gui, getModel().getIntruder(), new IntruderViewer());

        gui.drawText(new Position(0, 0), "Remaining Moves: " + getModel().getIntruder().getMovesAvailable(), "#FFFFFF");
    }

    private <T extends Element> void drawElements(LanternaGUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(LanternaGUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
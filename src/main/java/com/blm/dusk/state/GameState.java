package com.blm.dusk.state;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.controller.game.ArenaController;
import com.blm.dusk.models.arena.Arena;
import com.blm.dusk.view.Viewer;
import com.blm.dusk.view.game.GameViewer;

public class GameState extends State<Arena> {

    public GameState(Arena arena){
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {

        return new ArenaController(getModel());
    }

    private int level = 0;
    public int getLevel() { return level; }
    public int nextLevel() { return ++level; }
}

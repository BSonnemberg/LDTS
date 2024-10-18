package com.blm.dusk.controller.game;

import com.blm.dusk.controller.Controller;
import com.blm.dusk.models.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}

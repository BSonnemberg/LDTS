package com.blm.dusk.models.menu;

import java.util.Arrays;
import java.util.List;

public class MenuLose {
    private final List<String> entries;
    private int currentEntry = 0;

    private int currentLevel = 1;

    public MenuLose() {

        this.entries = Arrays.asList("Play Again", "Back Menu");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

    public boolean isSelectedBackMenu() {
        return isSelected(1);
    }

    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public int getCurrentLevel(){return this.currentLevel;}
}

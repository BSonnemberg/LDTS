package com.blm.dusk.models.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {

        this.entries = Arrays.asList("Start Game", "Settings", "Exit");
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

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public boolean isSelectedSettings() {return isSelected(1);}

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }



}

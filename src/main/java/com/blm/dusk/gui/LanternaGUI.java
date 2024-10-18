package com.blm.dusk.gui;

import com.blm.dusk.models.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI {
    private Screen screen;

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        screen = new TerminalScreen(terminal);
        this.screen = createScreen(terminal);
    }


    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(width, height));
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        terminalFactory.setTerminalEmulatorTitle("Dusk82");
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("stages/dusk82-finalfont.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }


    public void clearScreen() throws IOException {
        screen.clear();
    }


    public void refresh() throws IOException {
        screen.refresh();
    }

    private void drawElement(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    public void drawIntruder(Position position) {
        drawElement(position.getX(), position.getY(), '?', "#7B68EE");
    }

    public void drawGoat(Position position) {
        drawElement(position.getX(), position.getY(), '@', "#CD7F32");
    }


    public void drawBlock(Position position) {
        drawElement(position.getX(), position.getY(), '#', "#D3D3D3");
    }

    public void drawKey(Position position) {drawElement(position.getX(), position.getY(), '>', "#FFFF00"); }

    public void drawDoor(Position position) {drawElement(position.getX(), position.getY(), '=', "#00CCEE");}

    public void drawBullet(Position position) {drawElement(position.getX(), position.getY(), ';', "#E32636");}

    public void drawPoint(Position position) { drawElement(position.getX(), position.getY(), '.', "#43A5BE"); }

    public void drawTree(Position position) {drawElement(position.getX(), position.getY(), '<', "#ADFF2F");}

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }


    public enum ACTION{UP, RIGHT, LEFT, DOWN, SHOOTUP, SHOOTDOWN, SHOOTLEFT, SHOOTRIGHT, SELECT, NONE, QUIT}

    public ACTION getAction() throws IOException {
        KeyStroke keyStroke=screen.pollInput();
        if(keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter() == 'w') return ACTION.UP ;
        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter() == 'a') return ACTION.LEFT ;
        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.DOWN ;
        if(keyStroke.getKeyType()==KeyType.Character && keyStroke.getCharacter() == 'd') return ACTION.RIGHT ;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.SHOOTUP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.SHOOTDOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.SHOOTLEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.SHOOTRIGHT;


        return ACTION.NONE;
    }

    public void close() throws IOException {
        screen.close();
    }


}


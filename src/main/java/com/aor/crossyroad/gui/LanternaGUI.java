package com.aor.crossyroad.gui;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
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
    public enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT};

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        Terminal terminal = createTerminal(width, height);
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
    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        return terminalFactory.createTerminal();
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        return ACTION.NONE;
    }
    public void drawTree(Position position) {
        drawCharacter(position.getX(), position.getY(), 'T', "#32CD32");
    }

    public void drawCar(Position position) {
        drawCharacter(position.getX(), position.getY(), 'D', "#EE4B2B");
    }

    public void drawSidewalk(Sidewalk sidewalk, int y) {
        for (Tree tree : sidewalk.getTrees()) {
            drawTree(tree.getPosition());
        }
    }
    public void drawSafe(){
        for (int i = 0; i < 100; i++) {
           drawCharacter(i, 2,'-',"#FFFFFF");
           drawCharacter(i, 31, '-', "#FFFFFF");
        }
    }
    public void drawRoad(Road road, int y) {
        for(Car c:road.getCars()){
            drawCar(c.getPosition());
        }
    }
    public void drawChicken(Position position) {
        drawCharacter(position.getX(), position.getY(), 'X', "#FFFF00");
    }
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }
    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }
    public void drawCoin(Position position){
        drawCharacter(position.getX(), position.getY(), '$',"#FFD700");
    }
    public void drawShop(Position position) {drawCharacter(position.getX(), position.getY(), 'S',"#FFFFFF");}
    public void clear() {
        screen.clear();
    }
    public void refresh() throws IOException {screen.refresh();}
    public void close() throws IOException {screen.close();}
}
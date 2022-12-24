package com.aor.crossyroad.gui;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Chicken;
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
import java.util.ArrayList;
import java.util.Objects;

public class LanternaGUI {
    private final Screen screen;
    public enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SPACE}

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadCrossyRoadFont();
        Terminal terminal = createTerminal(width, height,fontConfig);
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
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }
    private AWTTerminalFontConfiguration loadCrossyRoadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/CrossyRoadFont2.otf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        Font loadedFont = font.deriveFont(Font.PLAIN, 15);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter() == 'q' || keyStroke.getCharacter() == 'Q'))
            return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ')
            return ACTION.SPACE;
        return ACTION.NONE;
    }
    public void drawMenu(Position position,String string,String color){
        drawText(position,string,color);
    }
    public void drawPowerUp(Position position,String text,String color){
        drawText(position,text,color);
    }
    public void drawTree(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#32CD32");
    }
    public void drawCarLeft(Position position) {
        drawCharacter(position.getX(), position.getY(), 'j', "#EE4B2B");
    }
    public void drawCarRight(Position position){drawCharacter(position.getX(),position.getY(),'J',"#EE4B2B");}
    public void drawSidewalk( int y) {
        for(int i =1;i <39;i++){
            drawText(new Position(i,y+1)," ","#545454");
        }
    }
    public void drawSafe(){
        for (int i = 1; i < 39; i++) {
            drawCharacter(i, 3,'-',"#FFFFFF");
            drawCharacter(i, 32, '-', "#FFFFFF");
        }
    }
    public void drawChicken(Position position, char direction) {
        drawCharacter(position.getX(), position.getY(), direction, Chicken.getColor());
    }

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        if (Objects.equals(text, " ") || Objects.equals(text, "  ")) tg.setBackgroundColor(TextColor.Factory.fromString(color));
        else if (Objects.equals(text, "SHOP$")){
            for (int i = 0; i <= text.length()-1; i++) {
                tg.setBackgroundColor(tg.getCharacter(position.getX() + i, position.getY()).getBackgroundColor());
                tg.setForegroundColor(TextColor.Factory.fromString(color));
            }
        }
        else {tg.setForegroundColor(TextColor.Factory.fromString(color));}
        tg.putString(position.getX(), position.getY(), text);
    }
    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        String chars = " &/%*@";
        if (chars.contains("" + c)) tg.setBackgroundColor(tg.getCharacter(x,y+1).getBackgroundColor());
        if (c == 'S') tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }
    public void drawCoin(Position position){
        drawCharacter(position.getX(), position.getY(), '$',"#FFD700");
    }
    public void drawSpecialCoin(Position position) {
        drawCharacter(position.getX(), position.getY(), '$',"#E5E4E2");
    }
    public void drawShopInGame(Position position) {
        drawText(new Position(position.getX() - 2, position.getY() + 2), "  ","#545454");
        drawText(new Position(position.getX(), position.getY() + 2), "  ","#545454");
        drawText(new Position(position.getX() + 2, position.getY() + 2), " ","#545454");
        drawText(new Position(position.getX() - 2, position.getY() + 2),"SHOP$","#0A1172");
        drawCharacter(position.getX(), position.getY(),'S',"#964B00" );
        drawCharacter(position.getX() - 2, position.getY(),'S',"#545454" );
        drawCharacter(position.getX() - 1, position.getY(),'S',"#545454" );
        drawCharacter(position.getX() + 1, position.getY(),'S',"#545454" );
        drawCharacter(position.getX() + 2, position.getY(),'S',"#545454" );

    }
    public void drawShop(Position position,String text,String color){
        drawText(position,text,color);
    }
    public void drawBorder(int x,int y){
        drawCharacter(x,y,'ᗡ',"#028A0F");
    }
    public void clear() {
        screen.clear();
    }
    public void refresh() throws IOException {screen.refresh();}
    public void close() throws IOException {screen.close();}
}
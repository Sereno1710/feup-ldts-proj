package com.aor.crossyroad.gui;

import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.lines.Sidewalk;
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
        URL resource = getClass().getClassLoader().getResource("fonts/CrossyRoadFont.otf");
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
    public void drawTree(Position position) {
        drawCharacter(position.getX(), position.getY(), 'W', "#32CD32");
    }
    public void drawCarLeft(Position position) {
        drawCharacter(position.getX(), position.getY(), 'j', "#EE4B2B");
    }
    public void drawCarRight(Position position){drawCharacter(position.getX(),position.getY(),'J',"#EE4B2B");}
    public void drawSidewalk(Sidewalk sidewalk, int y) {
        for(int i =1;i <39;i++){
            drawText(new Position(i,y+1)," ","#D3D3D3");
        }
    }
    public void drawRoad(Road road,int y) {
        //drawRectangle
    }
    public void drawSafe(){
        for (int i = 1; i < 39; i++) {
            drawCharacter(i, 3,'-',"#FFFFFF");
            drawCharacter(i, 32, '-', "#FFFFFF");
        }
    }
    public void drawChicken(Position position,char direction) {
        drawCharacter(position.getX(), position.getY(), direction, "#FFFF00");
    }

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        if (text == " " || text == "  ") tg.setBackgroundColor(TextColor.Factory.fromString(color));
        else {tg.setForegroundColor(TextColor.Factory.fromString(color));}
        tg.putString(position.getX(), position.getY(), text);
    }
    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        if (c == ' '|| c== '&' || c== '/' || c== '%' || c=='*' || c=='W') tg.setBackgroundColor(tg.getCharacter(x,y+1).getBackgroundColor());
        else if( c== 'S' || c== '-') tg.setBackgroundColor(TextColor.Factory.fromString(color));
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y +1, "" + c);
    }
    public void drawCoin(Position position){
        drawCharacter(position.getX(), position.getY(), '$',"#FFD700");
    }
    public void drawSpecialCoin(Position position) {
        drawCharacter(position.getX(), position.getY(), '$',"#E5E4E2");
    }
    public void drawShop(Position position) {
        String s1 = "  ";
        String s2 = "  ";
        String s3 = " ";
        drawText(new Position(position.getX()-1,position.getY()-1),s1,"#FFFFFF");
        drawText(new Position(position.getX()-1, position.getY() ),s2,"#FFFFFF");
        drawText(new Position(position.getX()-1, position.getY()+1), s3,"#FFFFFF");
        drawCharacter(position.getX(), position.getY(),'S',"#964B00" );
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
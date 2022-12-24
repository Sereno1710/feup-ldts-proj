package com.aor.crossyroad.gui;

import com.aor.crossyroad.model.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private LanternaGUI gui;
    private LanternaGUI gui2;
        private TextGraphics textgraphics;
        @BeforeEach
        void setUp() {
            gui2= Mockito.mock(LanternaGUI.class);
            Screen screen = Mockito.mock(Screen.class);
            textgraphics = Mockito.mock(TextGraphics.class);
            Mockito.when(screen.newTextGraphics()).thenReturn(textgraphics);
            gui = new LanternaGUI(screen);
            Mockito.when(textgraphics.getCharacter(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Mockito.mock(TextCharacter.class));

        }
        @Test
        void drawCarRight(){
            gui.drawCarRight(new Position(1,1));
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(238, 75 ,43));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "J");
        }
        @Test
        void drawCarLeft(){
            gui.drawCarLeft(new Position(1,1));
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(238, 75 ,43));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "j");
        }
        @Test
        void drawTree(){
            gui.drawTree(new Position(1,1));
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(50, 205 ,50));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "@");
        }
        @Test
        void drawSpecialCoin(){
            gui.drawSpecialCoin(new Position(1,1));
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(229, 228 ,226));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "$");
        }
        @Test
        void drawCoin(){
            gui.drawCoin(new Position(1,1));
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "$");
        }
        @Test
        void drawChicken() {
            gui.drawChicken(new Position(1, 1),'&');
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "&");
        }
        @Test
        void drawText() {
            gui.drawText(new Position(1, 1), "Crossy Road Best Game", "#FFFF00");
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,255,0));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 1, "Crossy Road Best Game");
        }
        @Test
        void drawBorder(){
            gui.drawBorder(1,1);
            Mockito.verify(textgraphics,Mockito.times(1)).setForegroundColor(new TextColor.RGB(2,138,15));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1,2,"ᗡ");
        }
        @Test
        void drawSafe(){
            gui.drawSafe();
            Mockito.verify(textgraphics,Mockito.times(76)).putString(Mockito.anyInt(),Mockito.anyInt(),Mockito.anyString());
        }
        @Test
        void drawShop(){
            gui.drawShop(new Position(1,2),"SHOP$","#FFFFFF");
            Mockito.verify(textgraphics, Mockito.times(5)).setForegroundColor(new TextColor.RGB(255,255,255));
            Mockito.verify(textgraphics,Mockito.times(1)).putString(1,2,"SHOP$");
        }
        @Test
        void  drawSidewalk(){
            gui.drawSidewalk(5);
            Mockito.verify(textgraphics,Mockito.times(38)).putString(Mockito.anyInt(),Mockito.anyInt(),Mockito.anyString());
        }
        @Test
        void refresh() throws IOException {
            gui2.refresh();
            Mockito.verify(gui2,Mockito.times(1)).refresh();
        }
        @Test
        void clear() throws IOException {
            gui2.clear();
            Mockito.verify(gui2,Mockito.times(1)).clear();
        }
        @Test
        void close() throws IOException {

            gui2.close();
            Mockito.verify(gui2,Mockito.times(1)).close();
        }
}


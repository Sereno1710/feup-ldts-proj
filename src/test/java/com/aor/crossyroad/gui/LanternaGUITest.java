package com.aor.crossyroad.gui;

import com.aor.crossyroad.model.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class LanternaGUITest {
        private Screen screen;
        private LanternaGUI gui;
        private TextGraphics textgraphics;
        @BeforeEach
        void setUp() {

            screen = Mockito.mock(Screen.class);
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

}


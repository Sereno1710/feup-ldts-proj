package com.aor.crossyroad.gui;

import com.aor.crossyroad.gui.LanternaGUI;
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
            gui = new LanternaGUI(screen);
            //Mockito.when(textgraphics.getCharacter(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Mockito.mock(TextCharacter.class));

        }
        @Test
        void drawChicken() {
            Mockito.verify(textgraphics,Mockito.times(1)).setBackgroundColor(new TextColor.RGB(255,255,0));
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


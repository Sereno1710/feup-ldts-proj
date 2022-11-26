import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
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
        }


        @Test
        void drawChicken() {
            gui.drawChicken(new Position(1, 1));

            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 2, "X");
        }

        @Test
        void drawText() {
            gui.drawText(new Position(1, 1), "Crossy Road Best Game", "#FFFF00");
            Mockito.verify(textgraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
            Mockito.verify(textgraphics, Mockito.times(1)).putString(1, 1, "Crossy Road Best Game");
        }
    }


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private Screen screen;
    private Arena arena;
    private State state;
    private final LanternaGUI gui;
    public Game() throws FontFormatException, IOException, URISyntaxException {
        int col=100,row=40;
        this.gui = new LanternaGUI(col,row);
        this.state= new MenuState(new Menu());
    }
    public void run() throws IOException{

            int FPS = 40;
            int frameTime = 1000 / FPS;

            while (this.state != null) {
                long startTime = System.currentTimeMillis();

                state.step(this, gui, startTime);

                long elapsedTime = System.currentTimeMillis() - startTime;
                long sleepTime = frameTime - elapsedTime;

                try {
                    if (sleepTime > 0) Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }
            }

            gui.close();
    }
    public void setState(State state) {
        this.state=state;
    }

    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException{
        new Game().run();
    }
}

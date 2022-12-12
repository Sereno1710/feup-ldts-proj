package com.aor.crossyroad;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.states.MenuState;
import com.aor.crossyroad.states.State;
import com.aor.crossyroad.model.menu.Menu;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private State state;
    private final LanternaGUI lanternaGUI;
    public Game() throws FontFormatException, IOException, URISyntaxException {
        int col = 40, row = 40;
        this.lanternaGUI = new LanternaGUI(col, row);
        this.state = new MenuState(new Menu());
    }
    public void run() throws IOException{
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, lanternaGUI, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {}
        }
        lanternaGUI.close();
    }
    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException{
        new Game().run();
    }
}

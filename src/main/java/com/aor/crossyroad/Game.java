package com.aor.crossyroad;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.states.MenuState;
import com.aor.crossyroad.states.State;
import com.aor.crossyroad.model.menu.Menu;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

@SuppressWarnings("ALL")
public class Game {
    @SuppressWarnings("rawtypes")
    private State state;

    public Game() {

        this.state = new MenuState(new Menu());
    }
    public void run() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 30;
        int frameTime = 1000 / FPS;
        LanternaGUI lanternaGUI = new LanternaGUI(40, 40);
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
    @SuppressWarnings("rawtypes")
    public void setState(State state) {
        this.state = state;
    }

    @SuppressWarnings("rawtypes")
    public State getState() {
        return state;
    }

    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException{
        new Game().run();
    }

}

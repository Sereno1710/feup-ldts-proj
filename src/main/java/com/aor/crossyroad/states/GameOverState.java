package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.menu.GameOverController;
import com.aor.crossyroad.model.menu.GameOver;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver>{

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }

}

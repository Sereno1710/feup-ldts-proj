package com.aor.crossyroad.states;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    protected State(T model) {
        this.model = model;
        this.controller = getController();
        this.viewer = getViewer();
    }
    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();
    public T getModel() {
        return model;
    }
    public void step(Game game, LanternaGUI gui, long time) throws IOException {
        LanternaGUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State<?> state = (State<?>) o;
        return model.equals(state.model) && controller.equals(state.controller) && viewer.equals(state.viewer);
    }
}

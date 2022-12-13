package com.aor.crossyroad.viewer;

import com.aor.crossyroad.gui.LanternaGUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;
    public Viewer(T type){
        this.model = type;
    }

    public T getModel() {
        return model;
    }
    public void draw(LanternaGUI lanternaGUI) throws IOException{
        lanternaGUI.clear();
        drawLines(lanternaGUI);
        drawElements(lanternaGUI);
        lanternaGUI.refresh();
    }
    protected abstract void drawElements(LanternaGUI lanternaGUI);
    protected abstract void drawLines(LanternaGUI lanternaGUI);
}

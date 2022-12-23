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
    public abstract void drawElements(LanternaGUI lanternaGUI);
    public abstract void drawLines(LanternaGUI lanternaGUI);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viewer<?> viewer = (Viewer<?>) o;
        return model.equals(viewer.getModel());
    }
}

package com.aor.crossyroad.model.game.lines;
public abstract class Line {
    private final int y;
    public Line(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
}

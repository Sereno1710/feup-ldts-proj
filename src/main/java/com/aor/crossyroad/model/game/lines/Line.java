package com.aor.crossyroad.model.game.lines;
public abstract class Line {
    protected  char code;
    private final int y;
    public Line(int y, char code) {
        this.y = y;
        this.code = code;
    }
    public int getY() {
        return y;
    }
}

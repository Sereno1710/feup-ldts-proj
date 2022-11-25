package com.aor.crossyroad.model.game.lines;

import com.aor.crossyroad.model.game.lines.Line;

public class Road extends Line {
    public Road(int y) {
        super(y, 'R');
    }
    @Override
    public void randomizeElements() {
        return;
    }
}

package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.lines.Line;

public interface LineViewer<T extends Line>{
    void draw(T line, LanternaGUI lanternaGui);

}

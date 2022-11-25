package com.aor.crossyroad.viewer.game;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.elements.Element;

public interface ElementViewer<T extends Element>{
    void draw(T element, LanternaGUI lanternaGui);
}

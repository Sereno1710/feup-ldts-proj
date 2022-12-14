package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.shop.SkinsController;
import com.aor.crossyroad.model.game.shop.Skins;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.shop.SkinsViewer;

public class SkinsState extends State<Skins> {

    public SkinsState(Skins skins) {
        super(skins);
    }
    @Override
    protected Viewer<Skins> getViewer() {
        return new SkinsViewer(getModel());
    }

    @Override
    protected Controller<Skins> getController() {
        return new SkinsController(getModel());
    }
}

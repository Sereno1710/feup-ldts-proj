package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.menu.MenuController;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model){
        super(model);
    }
    @Override
    protected Viewer<Menu> getViewer(){
        return new MenuViewer(getModel());
    }
    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

}

package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.menu.InstructionsController;
import com.aor.crossyroad.model.menu.InstructionsMenu;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.menu.InstructionsViewer;

import javax.swing.undo.StateEdit;

public class IntructionsState extends State<InstructionsMenu> {
    public IntructionsState(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsController(getModel());
    }
}

package com.aor.crossyroad.states;

import com.aor.crossyroad.model.menu.InstructionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InstructionsStateTest {
    private InstructionsState instructionsState;

    @BeforeEach
    void FillALl(){
        instructionsState=new InstructionsState(new InstructionsMenu());
    }
    @Test
    void NotNull(){
        assertNotNull(instructionsState.getModel());
        assertNotNull(instructionsState.getViewer());
        assertNotNull(instructionsState.getController());
    }
}

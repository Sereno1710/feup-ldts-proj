package com.aor.crossyroad.states;

import com.aor.crossyroad.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MenuStateTest {
    private MenuState menuState;

    @BeforeEach
    void FillALl(){
        menuState=new MenuState(new Menu());
    }
    @Test
    void NotNull(){
        assertNotNull(menuState.getModel());
        assertNotNull(menuState.getViewer());
        assertNotNull(menuState.getController());
    }
}

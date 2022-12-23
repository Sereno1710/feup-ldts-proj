package com.aor.crossyroad.states;

import com.aor.crossyroad.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOverStateTest {
    private GameOverState gameOverState;
    @BeforeEach
    void FillALl(){
        gameOverState=new GameOverState(new GameOver("1","2"));
    }
    @Test
    void NotNull(){
        assertNotNull(gameOverState.getModel());
        assertNotNull(gameOverState.getViewer());
        assertNotNull(gameOverState.getController());
    }
}

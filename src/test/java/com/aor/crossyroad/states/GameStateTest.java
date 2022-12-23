package com.aor.crossyroad.states;

import com.aor.crossyroad.model.game.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameStateTest {
    private GameState gameState;
    @BeforeEach
    void FillALl(){
        gameState=new GameState(new Arena(10,10));
    }
    @Test
    void NotNull(){
        assertNotNull(gameState.getModel());
        assertNotNull(gameState.getViewer());
        assertNotNull(gameState.getController());
    }
}

package com.aor.crossyroad.states;

import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PowerUpStateTest {
    private PowerUpsState powerUpsState;

    @BeforeEach
    void setUp(){
        powerUpsState=new PowerUpsState(new PowerUps(new ShopState(new Shop(new GameState(new Arena(1,1))))));
    }
    @Test
    void NotNull(){
        assertNotNull(powerUpsState.getModel());
        assertNotNull(powerUpsState.getController());
        assertNotNull(powerUpsState.getViewer());
    }
}

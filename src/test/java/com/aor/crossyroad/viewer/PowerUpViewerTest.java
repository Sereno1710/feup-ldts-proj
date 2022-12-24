package com.aor.crossyroad.viewer;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.PowerUps;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.states.ShopState;
import com.aor.crossyroad.viewer.shop.PowerUpViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PowerUpViewerTest {
    private PowerUpViewer powerUpViewer;
    private PowerUps powerUps;
    private LanternaGUI gui;
    @BeforeEach
    void setUp(){
        powerUps=new PowerUps(new ShopState(new Shop(new GameState(new Arena(40,40)))));
        gui= Mockito.mock(LanternaGUI.class);
        powerUpViewer =new PowerUpViewer(powerUps);
    }
    @Test
    void notNull(){
        assertNotNull(powerUpViewer);
        assertNotNull(gui);
        assertNotNull(powerUps);
    }
}

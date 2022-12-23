package com.aor.crossyroad.states;

import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShopStateTest {
    private ShopState shopState;
    @BeforeEach
    void setUp(){
        shopState=new ShopState(new Shop(new GameState(new Arena(1,1))));
    }

    @Test
    void NotNull(){
        assertNotNull(shopState.getModel());
        assertNotNull(shopState.getController());
        assertNotNull(shopState.getViewer());
    }
}

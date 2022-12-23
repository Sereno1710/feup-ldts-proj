package com.aor.crossyroad.states;

import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.game.shop.Skins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SkinsStateTest {
    private SkinsState skinsState;

    @BeforeEach
    void setUp(){
        skinsState=new SkinsState(new Skins(new ShopState(new Shop(new GameState(new Arena(1,1))))));
    }
    @Test
    void NotNull(){
        assertNotNull(skinsState.getModel());
        assertNotNull(skinsState.getViewer());
        assertNotNull(skinsState.getController());
    }
}

package com.aor.crossyroad.viewer;

import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.states.GameState;
import com.aor.crossyroad.viewer.shop.ShopViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShopViewerTest {
    private ShopViewer shopViewer;
    private Shop shop;
    private LanternaGUI gui;
    @BeforeEach
    void setUp(){
        shop=new Shop(new GameState(new Arena(40,40)));
        gui= Mockito.mock(LanternaGUI.class);
        shopViewer=new ShopViewer(shop);
    }
    @Test
    void notNull(){
        assertNotNull(shopViewer);
        assertNotNull(gui);
        assertNotNull(shop);
    }
    @Test
    void draw() throws IOException {
        shopViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui,Mockito.times(1)).drawShop(new Position(17,5),"SHOP","#FFD700");
        Mockito.verify(gui,Mockito.times(1)).drawShop(new Position(5,15),"Power-Ups","#39FF14");
        Mockito.verify(gui,Mockito.times(1)).drawShop(new Position(5,16),"Skins","#FFFFFF");
        Mockito.verify(gui,Mockito.times(1)).drawShop(new Position(5,17),"Exit","#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}

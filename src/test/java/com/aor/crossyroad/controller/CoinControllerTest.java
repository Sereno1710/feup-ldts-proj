package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.game.ChickenController;
import com.aor.crossyroad.controller.game.CoinController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.Coin;
import com.aor.crossyroad.model.game.lines.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CoinControllerTest {
    private List<Coin> coins;
    private Arena arena;
    private Chicken chicken;
    private Road road;
    private List<Road> roads;
    private ChickenController controller;
    private CoinController coinController;
    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        game= new Game();
        arena= new Arena(40,40);
        coins=new ArrayList<>();
        roads= new ArrayList<>();
        chicken= new Chicken(15,37);
        arena.setChicken(chicken);
        Coin c= new Coin(15,36);
        coins.add(c);
        road=new Road(36);
        road.setCoins(coins);
        roads.add(road);
        controller = new ChickenController(arena);
        arena.setRoadsRight(roads);
        coinController= new CoinController(arena);
    }
    @Test
    void ChickenGettingCoin(){
        controller.moveChickenUp();
        arena.isCar(chicken.getPosition());
        Integer actual= arena.getCoinAmount();
        assertEquals(1,actual);
        assertEquals(0, arena.getRoadsRight().get(0).getCoins().size());
    }
    @Test
    void CoinRandomize() throws IOException {
        coinController.step(game, LanternaGUI.ACTION.NONE,100000);
        assertNotEquals(arena.getRoadsRight().get(0).getCoins().get(0).getPosition(),new Position(15,36));
    }
}

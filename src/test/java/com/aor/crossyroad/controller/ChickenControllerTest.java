package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.game.elements.ChickenController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ChickenControllerTest {

    private ChickenController controller;
    private Chicken chicken;
    private Arena arena;
    private  Game game;
    @BeforeEach
    public void FillAll() throws IOException, URISyntaxException, FontFormatException {
        game= new Game();
        arena= new Arena(40,40);
        chicken = new Chicken(15,15);
        arena.setChicken(chicken);
        controller = new ChickenController(arena);
    }
    @Test
    public void ChickenMoveUp() throws IOException {
        controller.step(game, LanternaGUI.ACTION.UP,0);
        controller.getModel().getChicken().setDirection('&');
        assertEquals(new Position(15,14),chicken.getPosition());
    }
    @Test
    public void ChickenCantMoveUp() throws IOException {
        arena.setSidewalks(Arrays.asList());
        arena.setSidewalks(Arrays.asList(new Sidewalk(15)));
        for (Sidewalk i:arena.getSidewalks()){
            i.randomizeTrees();
            i.getTrees().add(new Tree(15,14));
        }
        controller.step(game, LanternaGUI.ACTION.UP,0);
        assertEquals(new Position(15,15),chicken.getPosition());
    }
        @Test
        public void ChickenMoveDown() throws IOException {
            controller.step(game, LanternaGUI.ACTION.DOWN,0);
            controller.getModel().getChicken().setDirection('*');
            assertEquals(new Position(15,16),chicken.getPosition());
        }
        @Test
        public void ChickenCantMoveDown() throws IOException {
            arena.setSidewalks(Arrays.asList());
            arena.setSidewalks(Arrays.asList(new Sidewalk(16)));
            for (Sidewalk i:arena.getSidewalks()){
                i.randomizeTrees();
                i.getTrees().add(new Tree(15,16));
            }
            controller.step(game, LanternaGUI.ACTION.DOWN,0);
            assertEquals(new Position(15,15),chicken.getPosition());
        }
        @Test
        public void ChickenMoveLeft() throws IOException {
            controller.step(game, LanternaGUI.ACTION.LEFT,0);
            controller.getModel().getChicken().setDirection('/');
            assertEquals(new Position(14,15),chicken.getPosition());
        }
        @Test
        public void ChickenCantMoveLeft() throws IOException {
            arena.setSidewalks(Arrays.asList());
            arena.setSidewalks(Arrays.asList(new Sidewalk(15)));
            for (Sidewalk i:arena.getSidewalks()){
                i.randomizeTrees();
                i.getTrees().add(new Tree(14,15));
            }
            controller.step(game, LanternaGUI.ACTION.LEFT,0);
            assertEquals(new Position(15,15),chicken.getPosition());
        }
        @Test
        public void ChickenMoveRight() throws IOException {
            controller.step(game, LanternaGUI.ACTION.RIGHT,0);
            controller.getModel().getChicken().setDirection('%');
            assertEquals(new Position(16,15),chicken.getPosition());
        }
        @Test
        public void ChickenCantMoveRight() throws IOException {
            arena.setSidewalks(Arrays.asList());
            arena.setSidewalks(Arrays.asList(new Sidewalk(15)));
            for (Sidewalk i:arena.getSidewalks()){
                i.randomizeTrees();
                i.getTrees().add(new Tree(16,15));
            }
            controller.step(game, LanternaGUI.ACTION.RIGHT,0);
            assertEquals(new Position(15,15),chicken.getPosition());
        }
        @Test
        void VerifySafeZoneTop() throws IOException {
            chicken.setPosition(new Position(15,4));
            controller.step(game, LanternaGUI.ACTION.UP,0);
            assertEquals('T',arena.getLastSafe());
        }
        @Test
        void VerifySafeZoneBot() throws IOException {
            chicken.setPosition(new Position(15,31));
            controller.step(game, LanternaGUI.ACTION.DOWN,0);
            assertEquals('B',arena.getLastSafe());
        }
        @Test
        void VerifyTreeRandomizer() throws IOException {
            List<Tree> notexpected;
            notexpected=arena.getSidewalks().get(0).getTrees();
            chicken.setPosition(new Position(15,4));
            controller.step(game, LanternaGUI.ACTION.UP,0);
            assertNotEquals(notexpected,arena.getSidewalks().get(0).getTrees());
        }
        @Test
        void  VerifyScoreRaising() throws IOException {
            chicken.setPosition(new Position(15,4));
            controller.step(game, LanternaGUI.ACTION.UP,0);
            assertNotEquals(0,arena.getScore());
        }
}

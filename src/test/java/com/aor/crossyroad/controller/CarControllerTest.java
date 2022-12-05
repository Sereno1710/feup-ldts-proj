package com.aor.crossyroad.controller;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.controller.game.CarLeftController;
import com.aor.crossyroad.controller.game.CarRightController;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.elements.cars.CarLeft;
import com.aor.crossyroad.model.game.elements.cars.CarRight;
import com.aor.crossyroad.model.game.lines.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CarControllerTest {
        private CarLeftController controller;
        private CarRightController controller2;
        private Chicken chicken;
        private Arena arena;
        private Game game;

        @BeforeEach
        void setUp() {
            arena = new Arena(10, 10);

            chicken = new Chicken(2, 2);
            arena.setChicken(chicken);

            arena.setRoadsLeft(Arrays.asList());
            arena.setRoadsRight(Arrays.asList());
            controller = new CarLeftController(arena);
            controller2=new CarRightController(arena);
            arena.LineCreator();
            game = Mockito.mock(Game.class);
        }

        @Test
        void moveCarsLeft() throws IOException {
            Car car = new CarLeft(5, 3);
            for (Road i: arena.getRoadsLeft()){
                i.getCars().add(car);
                i.setCars(i.getCars());}
            arena.setRoadsLeft(arena.getRoadsLeft());
            controller.step(game, LanternaGUI.ACTION.NONE, 1000);
            assertNotEquals(new Position(5, 3), car.getPosition());
        }
        @Test
        void moveCarsRight() throws IOException {
            Car car = new CarRight(4, 4);
            for (Road i: arena.getRoadsRight()){
                i.getCars().add(car);
                i.setCars(i.getCars());}
            arena.setRoadsRight(arena.getRoadsRight());
            controller2.step(game, LanternaGUI.ACTION.NONE, 1000);
            assertNotEquals(new Position(4, 4), car.getPosition());
        }


        @Test
        void CarLeftGap() throws IOException {
            Car car = new CarLeft(5, 3);
            for (Road i: arena.getRoadsLeft()){
                i.getCars().add(car);
                i.setCars(i.getCars());break;}
            arena.setRoadsLeft(arena.getRoadsLeft());

            long time = 0;

            while (car.getPosition().equals(new Position(5, 3))) {
                time += 300;
                controller.step(game, LanternaGUI.ACTION.NONE, time);
            }

            assertEquals(new Position(4, 3),car.getPosition());
        }
        @Test
        void CarRightGap() throws IOException {
            Car car = new CarRight(5, 4);
            for (Road i: arena.getRoadsRight()){
                i.getCars().add(car);
                i.setCars(i.getCars());break;}
            arena.setRoadsRight(arena.getRoadsRight());

            long time = 0;

            while (car.getPosition().equals(new Position(5, 4))) {
                time += 300;
                controller2.step(game, LanternaGUI.ACTION.NONE, time);
            }
            assertEquals(new Position(6, 4),car.getPosition());
        }
}


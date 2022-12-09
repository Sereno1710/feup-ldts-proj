package com.aor.crossyroad.controller.game;

import com.aor.crossyroad.Game;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.elements.Coin;
import com.aor.crossyroad.model.game.elements.cars.Car;
import com.aor.crossyroad.model.game.lines.Road;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.model.menu.Menu;
import com.aor.crossyroad.gui.LanternaGUI;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.states.MenuState;
import com.aor.crossyroad.states.ShopState;


import java.io.IOException;

public class ArenaController extends GameController {
    private final ChickenController chickenController;
    private final CarRightController carRightController;
    private final CarLeftController carLeftController;
    private final CoinController coinController;
    public ArenaController(Arena arena) {
        super(arena);
        this.chickenController = new ChickenController(arena);
        this.carRightController = new CarRightController(arena);
        this.carLeftController = new CarLeftController(arena);
        this.coinController= new CoinController(arena);
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) throws IOException {
        getModel().tickTime();
        if (action == LanternaGUI.ACTION.QUIT) {
            game.setState(new MenuState(new Menu()));
        }
        else if(getModel().isCar(getModel().getChicken().getPosition())|| getModel().getTime()==1){
            game.setState(new MenuState(new Menu(getModel().getCoinAmount().toString(),getModel().getScore().toString())));
        }
        else if(getModel().getShop().getPosition().equals(getModel().getChicken().getPosition())){
            game.setState(new ShopState(new Shop()));
        }
        else {
                chickenController.step(game, action, time);
                carRightController.step(game, action, time);
                carLeftController.step(game,action,time);
                coinController.step(game,action,time);
        }
    }
    public void EndGame(){
    }
}

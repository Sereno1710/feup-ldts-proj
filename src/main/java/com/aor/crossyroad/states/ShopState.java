package com.aor.crossyroad.states;

import com.aor.crossyroad.controller.Controller;
import com.aor.crossyroad.controller.shop.ShopController;
import com.aor.crossyroad.model.game.shop.Shop;
import com.aor.crossyroad.viewer.Viewer;
import com.aor.crossyroad.viewer.shop.ShopViewer;

public class ShopState extends State<Shop>{
    public ShopState(Shop shop) {
        super(shop);
    }

    @Override
    protected Viewer<Shop> getViewer() {
        return new ShopViewer(getModel());
    }
    @Override
    protected Controller<Shop> getController(){
        return new ShopController(getModel());
    }
}

package com.aor.crossyroad.model.menu;

import com.aor.crossyroad.model.game.elements.Chicken;

import java.util.Arrays;
public class Menu extends MenuPhases{
    private final Chicken chicken;
    public Menu() {
        super(Arrays.asList("Start","Instructions","Exit"));
        this.chicken=new Chicken(16,25);
    }
    public Chicken getChicken() {
        return chicken;
    }
}
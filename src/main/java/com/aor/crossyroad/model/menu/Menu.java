package com.aor.crossyroad.model.menu;
import java.util.Arrays;
import java.util.List;
public class Menu extends MenuPhases{
    private int currentOption = 0;

    public Menu() {
        super(Arrays.asList("Start","Exit"));
    }

    @Override
    public void nextOption() {currentOption++;if (currentOption > getNumberOptions()) currentOption = 0;}
    @Override
    public void previousOption() {currentOption--;if (currentOption < 0) currentOption = getNumberOptions()-1;}
    @Override
    public String getOption(int i) {
        return getOptions().get(i);
    }
    @Override
    public boolean isSelected(int i) {
        return currentOption == i;
    }
    @Override
    public boolean isSelectedExit() {
        return isSelected(1);
    }
    @Override
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    @Override
    public int getNumberOptions() {
        return this.getOptions().size();
    }
}
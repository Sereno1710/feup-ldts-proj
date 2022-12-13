package com.aor.crossyroad.model.menu;


import java.util.List;

public abstract class MenuPhases {
    private List<String> options;
    private int currentOption=0;
    public MenuPhases(List<String> options){
        this.options=options;
    }

    public void nextOption() {currentOption++;if (currentOption > getNumberOptions()) currentOption = 0;}
    public void previousOption() {currentOption--;if (currentOption < 0) currentOption = getNumberOptions()-1;}
    public String getOption(int i) {
        return options.get(i);
    }
    public boolean isSelected(int i) {
        return currentOption == i;
    }
    public boolean isSelectedExit() {
        return isSelected(1);
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public int getNumberOptions() {
        return this.options.size();
    }
}

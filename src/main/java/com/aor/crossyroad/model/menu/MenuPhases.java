package com.aor.crossyroad.model.menu;


import java.util.List;
import java.util.Objects;

public abstract class MenuPhases {
    private final List<String> options;
    private int currentOption=0;
    public MenuPhases(List<String> options){
        this.options=options;
    }
    public void nextOption() {currentOption++;if (currentOption >= getNumberOptions()) currentOption = 0;}
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

    public int getCurrentOption() {
        return currentOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuPhases that = (MenuPhases) o;
        return currentOption == that.currentOption && options.equals(that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, currentOption);
    }
}

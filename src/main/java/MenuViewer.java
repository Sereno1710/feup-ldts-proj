public class MenuViewer extends Viewer<Menu>{
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberOptions(); i++)
            lanternaGUI.drawText(new Position(5, 7 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#EE4B2B");
    }
}

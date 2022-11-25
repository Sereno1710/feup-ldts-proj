public class MenuViewer extends Viewer<Menu>{
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(LanternaGUI lanternaGUI) {
        lanternaGUI.drawText(new Position(5, 5), "Menu", "#FFD700");

        for (int i = 0; i < getModel().getNumberOptions(); i++)
            lanternaGUI.drawText(new Position(5, 7 + i), getModel().getOption(i), getModel().isSelected(i) ? "#39FF14" : "#FFFFFF");
    }
    @Override
    protected void drawLines(LanternaGUI lanternaGUI){
        return;
    }
}

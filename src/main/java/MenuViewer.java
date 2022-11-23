public class MenuViewer extends Viewer<Menu>{
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(LanternaGUI lanternaGui) {
        lanternaGui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getType().getNumberOptions(); i++)
            lanternaGui.drawText(
                    new Position(5, 7 + i),
                    getType().getOption(i),
                    getType().isSelected(i) ? "#39FF14" : "#EE4B2B");
    }
}

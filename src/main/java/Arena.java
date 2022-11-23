import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Chicken chicken;

    private List<Line> lines;
    // private List<Coin> coins;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public boolean isEmpty(Position position) {
        return true;
    }
}

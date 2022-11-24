import java.util.List;

public class Sidewalk extends Line{
    private List<Tree> trees;

    public Sidewalk(int y) {
        super(y, 'S');
    }

    public void randomizeTrees() {
    }

    public List<Tree> getTrees() {
        return trees;
    }
}

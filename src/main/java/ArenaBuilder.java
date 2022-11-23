import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setChicken(createChicken());
        arena.setLines(createLines());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract Chicken createChicken();
    
    protected abstract List<Line> createLines();
}

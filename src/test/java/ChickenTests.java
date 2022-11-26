import com.aor.crossyroad.controller.game.ChickenController;
import com.aor.crossyroad.model.Position;
import com.aor.crossyroad.model.game.arena.Arena;
import com.aor.crossyroad.model.game.elements.Chicken;
import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.lines.Sidewalk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ChickenTests {
    private ChickenController controller;
    private Chicken chicken;
    private Arena arena;
    @BeforeEach
    public void FillAll(){
        arena= new Arena(20,20);
        chicken = new Chicken(15,16);
        arena.setChicken(chicken);
        controller = new ChickenController(arena);
        arena.setSidewalks(Arrays.asList());
    }
    @Test
    public void ChickenMoveUp(){
        controller.moveChickenUp();
        assertEquals(new Position(15,15),chicken.getPosition());
    }
    @Test
    public void ChickenCantMoveUp(){
        arena.setSidewalks(Arrays.asList(new Sidewalk(15)));
        for (Sidewalk i: arena.getSidewalks()){
            i.randomizeTrees();
            i.getTrees().add(new Tree(15,15));
        }
        controller.moveChickenUp();
        assertEquals(new Position(15,16),chicken.getPosition());
    }
    @Test
    public void settingChicken(){
        chicken.getPosition().setY(19);
        assertEquals(new Position(15,19),chicken.getPosition());
    }
}

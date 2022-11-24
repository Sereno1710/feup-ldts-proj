import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChickenTests {
    private Chicken chicken;
    private Arena arena;
    @BeforeEach
    public void FillAll(){
        arena= new Arena(10,10);
        chicken = new Chicken(5,5);
        arena.setChicken(chicken);
    }
    @Test
    public void ChickenMoveUp(){
        arena.moveChicken(chicken.MoveUp());
        assertEquals(new Position(5,4),chicken.getPosition());
    }
    @Test
    public void ChickenCantMoveUp(){
        chicken.setPosition(new Position(1,0));
        arena.setChicken(chicken);
        arena.moveChicken(chicken.MoveUp());
        assertEquals(new Position(1,0),chicken.getPosition());
    }
}

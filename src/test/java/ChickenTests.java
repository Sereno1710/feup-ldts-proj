import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChickenTests {
    private Chicken chicken;
    private Line line;
    @BeforeEach
    public void FillAll(){
        line= new Line(10,10);
        chicken = new Chicken(5,5);
        line.setChicken(chicken);
    }
    @Test
    public void ChickenMoveUP(){
        line.moveChicken(chicken.MoveUp());
        assertEquals(new Position(5,4),chicken.getPosition());
    }
    @Test
    public void ChickenCantMoveUp(){
        chicken.setPosition(new Position(1,0));
        line.setChicken(chicken);
        line.moveChicken(chicken.MoveUp());
        assertEquals(new Position(1,0),chicken.getPosition());
    }
}

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Chicken extends Element{
    public Chicken(int x, int y){
        super(x,y);
    }
    public Position getChicken() {
        return getPosition();
    }
    public Position MoveUp(){
        return new Position(getPosition().getX(), getPosition().getY()-1);
    }
    public Position MoveDown(){
        return new Position(getPosition().getX(), getPosition().getY()+1);
    }
    public Position MoveLeft(){
        return new Position(getPosition().getX()-1, getPosition().getY());
    }
    public Position MoveRight(){
        return new Position(getPosition().getX()+1, getPosition().getY());
    }
    public void draw(TextGraphics graphics){
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), TextCharacter.fromCharacter('X')[0]);
    }

}

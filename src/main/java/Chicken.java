import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class Chicken {
    private Position position;
    public Chicken(int x, int y){
        position =new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position MoveUp(){
        return new Position(position.getX(), position.getY()-1);
    }
    public Position MoveDown(){
        return new Position(position.getX(), position.getY()+1);
    }
    public Position MoveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public Position MoveRight(){
        return new Position(position.getX()+1, position.getY());
    }
    public void draw(Screen screen){
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
        screen.setCharacter(position.getX()+1, position.getY(), TextCharacter.fromCharacter('X')[0]);
        screen.setCharacter(position.getX()-1, position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

}

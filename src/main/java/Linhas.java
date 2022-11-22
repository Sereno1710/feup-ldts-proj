import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.util.List;

public class Linhas {
    private int width;
    private int height;
    private Chicken chicken;
    private List<Tree> trees;
    private List<CarLeft> carsLeft;
    private List<CarRight> carsRight;
    public Linhas(int width,int height){

        this.height=height;this.width=width;
        chicken = new Chicken(50,5);
    }
    public Chicken getChicken() {return chicken;}
    public void setChicken(Chicken chicken) {this.chicken = chicken;}
    public List<CarLeft> getCarsLeft() {return carsLeft;}
    public List<CarRight> getCarsRight() {return carsRight;}
    public List<Tree> getTrees() {return trees;}
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#332244"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        chicken.draw(graphics);
    }
    public void processKey(KeyStroke key){
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveChicken(chicken.MoveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            moveChicken(chicken.MoveDown());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            moveChicken(chicken.MoveLeft());
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
           moveChicken(chicken.MoveRight());
        }
    }
    public void moveChicken(Position position){
        if (canMove(position)) {
            chicken.setPosition(position);
        }
    }
    public boolean canMove(Position position){
        return ((position.getX() >= 0 && position.getY() >= 0  ) && (position.getX() < width && position.getY() < height));
    }
}

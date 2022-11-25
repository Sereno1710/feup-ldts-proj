import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
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
        chicken=new Chicken(width/2, height-1);
        LineCreator();
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
        return (position.getX() < width && position.getY() < height && position.getX() >= 0 && position.getY() >= 0);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#332244"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        chicken.draw(graphics);
    }
    public void LineCreator(){
        int i=6;
        List<Line> lines =new ArrayList<>();
        while(i>=6 && i<34){
            if(i%5==0){
                Sidewalk ns=new Sidewalk(i++);
                lines.add(ns);
            }
            else {
                Road nr = new Road(i++);
                lines.add(nr);
            }
        }
        setLines(lines);
    }

    /*public void processKey(KeyStroke key){
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
    }*/
    public void moveChicken(Position position){
        if (canMove(position)) {
            chicken.setPosition(position);
        }
    }
    public boolean canMove(Position position){
        return ((position.getX() >= 0 && position.getY() >= 0) && (position.getX() < width && position.getY() < height));
    }
}

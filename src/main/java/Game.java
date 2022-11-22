import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
public class Game {
    Chicken chicken = new Chicken(5,20);
    private Screen screen;
    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(100, 100);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public void MoveChicken(Position position){
        chicken.setPosition(position);
    }
    public void processKey(KeyStroke key){
        if (key.getKeyType() == KeyType.ArrowUp) {
            MoveChicken(chicken.MoveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            MoveChicken(chicken.MoveDown());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            MoveChicken(chicken.MoveLeft());
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            MoveChicken(chicken.MoveRight());
        }
    }
    public void run() throws IOException{
            while (true){
                draw();
                KeyStroke key = screen.readInput();
                processKey(key);
                if (key.getKeyType()== KeyType.Character && key.getCharacter() == 'q'){
                    this.screen.close();
                }
                if(key.getKeyType() == KeyType.EOF){break;}
            }
    }
    private void draw()throws IOException{
        screen.clear();
        chicken.draw(screen);
        screen.refresh();
    }
}

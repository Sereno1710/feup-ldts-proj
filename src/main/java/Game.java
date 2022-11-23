import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
public class Game {
    private Screen screen;
    private Arena arena;
    public Game(){
        try {
            int col=100,row=40;
            TerminalSize terminalSize = new TerminalSize(col, row);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            arena = new Arena(col,row);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException{
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            arena.processKey(key);
            if (key.getKeyType()== KeyType.Character && key.getCharacter() == 'q'){
                this.screen.close();
            }
            if(key.getKeyType() == KeyType.EOF){break;}
        }
    }
    private void draw()throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public static void main(String[] args) throws IOException{
        new Game().run();
    }
}

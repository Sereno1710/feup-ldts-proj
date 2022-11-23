import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public abstract class Line {
    private int y;
    public Line(int y){ this.y = y; }
    public int getY(){ return y; }
    public void setY(int y){ this.y = y; }
}

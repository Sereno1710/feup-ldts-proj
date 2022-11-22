import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    // void drawTree(Sidewalk sidewalk);

    void drawCarLeft(Position position);

    void drawCarRight(Position position);

    void drawCoin(Position position);

    void drawSidewalk(int y);

    void drawChicken(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
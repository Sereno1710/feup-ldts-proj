public abstract class Line {
    protected static char code;
    private int y;
    public Line(int y, char code) {
        this.y = y;
        this.code = code;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public static char getCode() {
        return code;
    }
}

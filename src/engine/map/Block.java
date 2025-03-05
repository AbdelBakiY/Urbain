package engine.map;


public class Block {
    private int line;
    private int column;
    private int type;

    public Block(int line, int column, int type) {
        this.line = line;
        this.column = column;
        this.type = type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public int getType() {
        return type;
    }
}


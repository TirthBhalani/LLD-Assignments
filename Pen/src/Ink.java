public class Ink {
    private String color;
    private int level;

    public Ink(String color) {
        this.color = color;
        this.level = 100;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}

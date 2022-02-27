package com.example.omok;

public class Stone {

    private String Color;
    private int x;
    private int y;

    public Stone(String color, int x, int y) {
        this.Color = color;
        this.x = x - 1;
        this.y = y - 1;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

package com.jackpan.lambda;

public class Apple {

    /**
     * 苹果的颜色，泛型
     */
    private Color color;

    /**
     * 苹果的重量
     */
    private Integer weight;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public enum Color {
        GREEN,RED;
    }
}

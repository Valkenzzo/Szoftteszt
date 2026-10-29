package org.example;

public class Table {

    private int width, length, height, currentHeight, numberOfLegs;
    private boolean isAdjustable;
    private String color;

    public Table(int width, int length, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Table(int width, int length, int height, int currentHeight, boolean isAdjustable) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.currentHeight = currentHeight;
        this.isAdjustable = isAdjustable;
    }

    public void setHeight(int value) {

        if (!isAdjustable) {
            return;
        }

        if (value < 0 || value > 200) {
            return;
        }


        this.height = value;
    }


    public void repaint(String color) {

        if (color == null || color.trim().isEmpty())
            return;

        this.color = color;
    }

    public void setNumberOfLegs(int number) {
        this.numberOfLegs = number;
    }

    public int area() {
        return width * length;
    }

    public int getCapacity() {
        return length / 60;
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public boolean isAdjustable() {
        return isAdjustable;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }


    public boolean isStable() {
        return numberOfLegs >= 3;
    }

    public boolean isFoldable() {
        return isAdjustable && numberOfLegs >= 4;
    }

    public int getPerimeter() {
        return 2 * height + 2 * length;
    }

    public String getColor() {
        return color;
    }
}

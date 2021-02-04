package com.itacademy.java.oop.basics.task1;

public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    double calculateArea() {
        return side * side;
    }

    @Override
    double calculatePerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", area=" + calculateArea() +
                ", perimeter=" + calculatePerimeter()+ '}';
    }
}

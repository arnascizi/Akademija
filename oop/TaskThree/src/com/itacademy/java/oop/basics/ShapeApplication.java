package com.itacademy.java.oop.basics;

public class ShapeApplication {

    public static void main(String[] args) {
        Square smallSquare = new Square(3, 4);
        Square bigSquare = new Square(12, 15);
        Square mediumSquare = new Square(8, 8);
        Square[] squares = {smallSquare, bigSquare, mediumSquare};

        for (Square square: squares) {
            if (square.getLength() < 0 || square.getWidth() < 0) {
                System.out.println("The shape " + square + " has a negative value");
            } else {
                System.out.println("Square: " + square + ". Area = " + square.getArea() + " and perimeter = " + square.getPerimeter());
            }
        }
    }
}

package com.itacademy.java.oop.basics;

import java.util.Arrays;

public class PointApplication {
    public static void main(String[] args) {
        MyPoint pointA = new MyPoint();
        MyPoint pointB = new MyPoint();

        pointA.setX(8);
        pointA.setY(3);
        pointB.setXY(5,9);
        System.out.println(pointA.getX());
        System.out.println(pointA.getY());
        System.out.println(Arrays.toString(pointB.getXY()));
        System.out.println(pointB);
        System.out.printf("Distance between pointA and (6,6): %.2f%n", pointA.distance(6, 6));
        System.out.printf("Distance between pointA and pointB: %.2f%n", pointA.distance(pointB));
        System.out.printf("Distance from (0,0) to pointA: %.2f%n", pointA.distance());

        for(int coord : pointA.getXY()) {
            System.out.println(coord);
        }

        System.out.println(pointB.getXY()[0] + " " + pointB.getXY()[1]);
    }
}

package com.itacademy.java.oop.basics.task2;

public class BicycleApplication {

    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike(3, 32);
        RoadBike roadBike = new RoadBike(5, 22);

        System.out.println(mountainBike);
        System.out.println(roadBike);


        mountainBikeCheck(mountainBike);
        roadBikeCheck(roadBike);

        System.out.println("The winner is: " + Speedometer.chooseWinner(mountainBike.getSpeed(), roadBike.getSpeed()).getDisplayValue());
        System.out.println("The winner is: " + Speedometer.chooseWinner(mountainBike, roadBike).getDisplayValue());

    }

    private static void roadBikeCheck(RoadBike roadBike) {
        try {
            roadBike.speedUp(10);
            roadBike.speedUp(10);
            roadBike.speedUp(-10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            roadBike.speedUp(60);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            roadBike.applyBrakes(-5);
            roadBike.applyBrakes(10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            roadBike.applyBrakes(-50);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            roadBike.changeGear(1);
            roadBike.changeGear(2);
            roadBike.changeGear(3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            roadBike.changeGear(-1);
            roadBike.changeGear(-2);
            roadBike.changeGear(-3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            for (int i = 0; i < roadBike.getGear(); i++) {
                roadBike.changeGear(1);
            }
            roadBike.changeGear(2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            for (int i = 0; i < roadBike.getGear() + 3; i++) {
                roadBike.changeGear(-2);
            }
            roadBike.changeGear(-2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mountainBikeCheck(MountainBike mountainBike) {
        try {
            mountainBike.speedUp(12);
            mountainBike.speedUp(70);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            mountainBike.speedUp(18);
            mountainBike.speedUp(-10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            mountainBike.applyBrakes(3);
            mountainBike.applyBrakes(-11);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            mountainBike.applyBrakes(10);
            mountainBike.applyBrakes(10);
            mountainBike.applyBrakes(11);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            mountainBike.changeGear(1);
            mountainBike.changeGear(-1);
            mountainBike.changeGear(-2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            for (int i = 0; i < mountainBike.getGear(); i++) {
                mountainBike.changeGear(-1);
            }
            mountainBike.changeGear(-1);
            mountainBike.changeGear(-1);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        try {
            for (int i = 0; i < 20; i++) {
                mountainBike.changeGear(1);
            }
            mountainBike.changeGear(1);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

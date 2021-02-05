package com.itacademy.java.oop.basics.task2;

public class RoadBike implements Bicycle {

    private int gear;
    private int speed;

    public RoadBike(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void changeGear(int newGear) {
        switch (newGear) {
            case 1:
            case 2:
                if ((getGear() + newGear) > 10) {
                    throw new ArithmeticException("Highest possible gear has been reached!");
                } else {
                    this.gear += newGear;
                    System.out.println("Gear has changed! Current Road Bikes gear is: " + getGear());
                }
                break;
            case -1:
            case -2:
                if ((getGear() + newGear) < 0) {
                    throw new ArithmeticException("lowest possible gear has been reached!");
                } else {
                    this.gear += newGear;
                    System.out.println("Gear has changed! Current Road Bikes gear is: " + getGear());
                }
                break;
            default:
                throw new IllegalArgumentException("You can't change gears by " + newGear + " ammount. " +
                        "You can change gears using -2, -1, 1 and 2 values");
        }
    }

    @Override
    public void speedUp(int increment) {
        if (increment < 0) {
            throw new IllegalArgumentException("Use only positive values for speeding up!");
        } else if ((increment + getSpeed()) > 50) {
            throw new ArithmeticException("Increment is too high! Highest allowed increment is: " + Math.abs((50 - getSpeed())));
        } else {
            this.speed += increment;
            System.out.println("Speed increased! Current Road Bike's speed is: " + getSpeed());
        }
    }

    @Override
    public void applyBrakes(int decrement) {
        if (decrement >= 0) {
            throw new IllegalArgumentException("Use only negative values for braking!");
        } else if ((getSpeed() + decrement) < 0) {
            throw new ArithmeticException("Road bike speed cannot be negative!");
        } else {
            this.speed += decrement;
            System.out.println("Brakes applied. Current Road bike speed is: " + getSpeed());
        }
    }

    @Override
    public String toString() {
        return "RoadBike{" +
                "current gear=" + gear +
                ", current speed=" + speed +
                '}';
    }
}

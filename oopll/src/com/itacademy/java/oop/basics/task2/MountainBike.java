package com.itacademy.java.oop.basics.task2;

public class MountainBike implements Bicycle {

    private int gear;
    private int speed;

    public MountainBike(int gear, int speed) {
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
                if ((getGear() + newGear) > 20) {
                    throw new ArithmeticException("Highest possible gear has been reached!");
                } else {
                    this.gear += newGear;
                    System.out.println("Gear has changed! Current Mountain Bikes gear is: " + getGear());
                }
                break;
            case -1:
                if ((getGear() + newGear) < 0) {
                    throw new ArithmeticException("lowest possible gear has been reached!");
                } else {
                    this.gear += newGear;
                    System.out.println("Gear has changed! Current Mountain Bikes gear is: " + getGear());
                }
                break;
            default:
                throw new IllegalArgumentException("You can't change gears by " + newGear + " ammount. " +
                        "You can change gears using -1 and 1 values");
        }
    }

    @Override
    public void speedUp(int increment) {
        if (increment < 0) {
            throw new IllegalArgumentException("You can't use a negative value for speeding up!");
        } else if ((getSpeed() + increment) > 100) {
            throw new ArithmeticException("Increment is too high! Highest allowed increment is: " + Math.abs((100 - getSpeed())));
        } else {
            this.speed += increment;
            System.out.println("Speed increased! Current Mountain Bike's speed is: " + getSpeed());
        }
    }

    @Override
    public void applyBrakes(int decrement) {
        if (decrement <= 0) {
            throw new IllegalArgumentException("You can't use a negative value for braking!");
        } else if (decrement > 10) {
            throw new ArithmeticException("Breaking value is too high! Maximum breaking value is: " + 10);
        } else {
            this.speed -= decrement;
            System.out.println("Brakes applied. Current Mountain bike speed is: " + getSpeed());
        }
    }

    @Override
    public String toString() {
        return "MountainBike{" +
                "current gear=" + gear +
                ", current speed=" + speed +
                '}';
    }
}

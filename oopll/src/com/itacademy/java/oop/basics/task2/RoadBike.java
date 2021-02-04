package com.itacademy.java.oop.basics.task2;

public class RoadBike implements Bicycle {

    private int gear;
    private int speed;

    public RoadBike() {
    }

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

    }

    @Override
    public void speedUp(int increment) {

    }

    @Override
    public void applyBrakes() {

    }

    @Override
    public String toString() {
        return "RoadBike{" +
                "gear=" + gear +
                ", speed=" + speed +
                '}';
    }
}

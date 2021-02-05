package com.itacademy.java.oop.basics.task2;

public class Speedometer {

    public static Bike chooseWinner(MountainBike mountainBike, RoadBike roadBike) {
        if (mountainBike.getSpeed() > roadBike.getSpeed()) {
            return Bike.MOUNTAIN;
        } else {
            return Bike.ROAD;
        }
    }

    public static Bike chooseWinner(int mountainBikeSpeed, int roadBikeSpeed) {
        if (mountainBikeSpeed > roadBikeSpeed) {
            return Bike.MOUNTAIN;
        } else {
            return Bike.ROAD;
        }
    }
}

package com.itacademy.java.oop.basics;

public class TravelApplication {

    public static class TravelManager {

        public static Family changeDestination(Family family, TravelDestination destination) {
            if (family.getTravelDestination() == destination) {
                return family;
            } else {
                family.setTravelDestination(destination);
                return family;
            }
        }

        public static void travel(Family family) {
            double carTravelDistance = family.getVehicle().maxTravelDistance();
            double destinationDistance = family.getTravelDestination().getDistance();
            if (carTravelDistance >= destinationDistance) {
                System.out.println("The family is able to travel to their destination");
            } else {
                double remainingDistance = destinationDistance - carTravelDistance;
                double fuelNeeded = (family.getVehicle().getConsumption() * remainingDistance) / 100;
                System.out.println("The family is unable to travel to their destination, they need " + fuelNeeded + "l of fuel");
            }
        }

        public static void printFamilyMembers(Family family) {
            for (Person person : family.getPeople()) {
                System.out.println(person);
            }
        }
    }

    public static void main(String[] args) {
        Person john = new Person("John", "Doe", Gender.MALE, 35);
        Person jane = new Person("Jane", "Doe", Gender.FEMALE, 33);
        Person bob = new Person("Bob", "Jones", Gender.MALE, 28);
        Person sam = new Person("Samantha", "Jones", Gender.FEMALE, 30);
        Vehicle fiat = new Vehicle("Fiat", "500", 12.0, 6.8);
        Vehicle mini = new Vehicle("Mini", "Cooper", 36.2, 8.1);
        TravelDestination klaipeda = new TravelDestination("Klaipėdos rajonas", "Klaipėda", 315.00);
        TravelDestination alytus = new TravelDestination("Alytaus rajonas", "Alytus", 86.00);
        Family doe = new Family(new Person[]{john, jane}, mini, alytus);
        Family jones = new Family(new Person[]{bob, sam}, fiat, alytus);
        TravelManager.printFamilyMembers(doe);
        System.out.println(doe);
        System.out.println(jones);
        TravelManager.changeDestination(jones, klaipeda);
        System.out.println(jones);
        TravelManager.travel(doe);
        TravelManager.travel(jones);
    }
}

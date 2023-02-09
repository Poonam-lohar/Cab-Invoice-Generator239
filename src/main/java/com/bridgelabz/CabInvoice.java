package com.bridgelabz;

public class CabInvoice {

    static final double COST_PER_KM = 10;
    static final double COST_PER_MIN = 1;

    public double calculateFare(double distance, double time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return fare;
    }

    public double calculateTotalFare(Ride[] rideArray) {
        double totalFare = 0;
        for (Ride ride : rideArray) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rideArray) {
        double totalFare = calculateTotalFare(rideArray);
        double totalRides = rideArray.length;
        double avgFare = totalFare / totalRides;
        return new Invoice(totalFare, (int) totalRides, avgFare);


    }
}

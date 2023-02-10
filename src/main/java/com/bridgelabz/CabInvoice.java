package com.bridgelabz;


import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CabInvoice {
    static List<Customer> customerList = new ArrayList<>();

    static final double COST_PER_KM = 10;
    static final double COST_PER_MIN = 1;
    static final double MINIMUM_FARE = 5;


    public double calculateFare(double distance, double time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        if (fare < 5)
            fare = MINIMUM_FARE;

        return fare;
    }

    public double calculateFare(Ride[] rideArray) {
        double totalFare = 0;
        for (Ride ride : rideArray) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rideArray) {
        double totalFare = calculateFare(rideArray);
        int totalRides = rideArray.length;
        double avgFare = totalFare / totalRides;
        return new Invoice(totalFare, totalRides, avgFare);
    }

    public Invoice generateInvoice(int id) {
        List<Customer> customerList1 = customerList.stream().filter(customer -> customer.id == id).collect(Collectors.toList());
        Customer customer = customerList1.get(0);
        return generateInvoice(customer.rideList);
    }
}

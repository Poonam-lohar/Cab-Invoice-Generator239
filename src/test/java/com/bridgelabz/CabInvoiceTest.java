package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabInvoiceTest {

    CabInvoice cabInvoice = new CabInvoice();

    /* Checking total fare */
    @Test
    void givenDistanceAndTimeShouldReturnTotalFare() {
        double actualFare = cabInvoice.calculateFare(2.0, 5.0);
        Assertions.assertEquals(25, actualFare);
    }

    /* Checking minimum fare */
    @Test
    void givenDistanceAndTimeShouldReturnMinimumFare() {
        double actualFare = cabInvoice.calculateFare(0.1, 0.5);
        Assertions.assertEquals(5, actualFare);
    }

    @Test
    void givenNumberOfRidesShouldReturnTotalFare() {
        Ride[] arr = {new Ride(2.0, 5.0), new Ride(3.0, 7.0), new Ride(0.1, 0.3)};
        double fare1 = cabInvoice.calculateFare(arr);
        Assertions.assertEquals(67, fare1);
    }

    @Test
    void givenMultipleRidesShouldReturnInvoice() {
        Ride[] arr = {new Ride(2.0, 5.0), new Ride(3.0, 7.0), new Ride(0.1, 0.3)};
        Invoice actualInvoice = cabInvoice.generateInvoice(arr);
        Invoice expectedInvoice = new Invoice(67.0, 3, 67.0 / 3);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }

    @Test
    void givenUserId_shouldReturnInvoice(){
        Ride[] rides1 = {new Ride(2.0, 5.0), new Ride(3.0, 7.0), new Ride(0.1, 0.3)};
        Customer customer1 = new Customer(1);
        customer1.rideList = rides1;
        CabInvoice.customerList.add(customer1);
        Invoice actualInvoice = cabInvoice.generateInvoice(rides1);
        Invoice expectedInvoice = new Invoice(67.0,3,22.333333333333332);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenUserIdShouldReturnInvoiceForPremiumRides(){
        Ride ride1 = new Ride(Ride.Category.PRIMIUM_RIDE,8,4);
        Ride ride2 = new Ride(Ride.Category.PRIMIUM_RIDE,6,3);
        Ride[] rides2 =new Ride[]{ride1,ride2};
        Customer customer2 = new Customer(2);
        customer2.rideList = rides2;
        CabInvoice.customerList.add(customer2);
        Invoice actualInvoice = cabInvoice.generateInvoice(rides2);
        Invoice expectedInvoice = new Invoice(147.0,2,73.5);
        Assertions.assertEquals(expectedInvoice,actualInvoice);

    }
}

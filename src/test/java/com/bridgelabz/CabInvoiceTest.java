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
}

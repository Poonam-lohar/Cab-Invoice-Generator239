package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {

    CabInvoice cabInvoice = new CabInvoice();


    @Test
    void givenDistanceAndTimeShouldReturnTotalFare(){

        double fare = cabInvoice.calculateFare(5,5.1);
        Assertions.assertEquals(55.1,fare);
    }
    @Test
    void givenMultipleRidesShouldReturnTotalFare(){
        Ride[] rideArray = {new Ride(2.0,5.0), new Ride(3.0,7.0),new Ride(0.1,0.3)};
        double fare = cabInvoice.calculateTotalFare(rideArray);
        Assertions.assertEquals(63.3,fare);
    }
    @Test
    void givenMultipleRidesShouldReturnInvoice(){
        Ride[] rideArray = {new Ride(2.0,5.0), new Ride(3.0,7.0),new Ride(0.1,0.3)};
        Invoice actualInvoice = cabInvoice.generateInvoice(rideArray);
        Invoice expectedInvoice = new Invoice(67.0,3,67.0/3);
        Assertions.assertEquals(expectedInvoice,actualInvoice);

    }
}

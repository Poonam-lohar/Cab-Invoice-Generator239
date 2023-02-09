package com.bridgelabz;

import java.util.Objects;

public class Invoice {

    int totalRides;
    double totalFare;
    double avgFare;

    public Invoice(double totalFare, int totalRides, double avgFare) {

        this.totalFare = totalFare;
        this.avgFare = avgFare;
        this.totalRides = this.totalRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalRides == invoice.totalRides && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, totalFare, avgFare);
    }
}

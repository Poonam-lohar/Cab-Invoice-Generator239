package com.bridgelabz;

public class Ride {

    double distance;
    double time;
    private Category category;

    public Ride(Category category, double distance, double time) {
        this.distance = distance;
        this.time = time;
        this.category = category;
    }

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }
    public enum Category {
        NORMAL_RIDE(10,1,5),PRIMIUM_RIDE(15,2,20);
        public double costPerKm;
        public int costPerMinute;
        public double miniFarePerRide;

        Category(double costPerKm,int costPerMinute,double miniFarePerRide){
            this.costPerKm = costPerKm;
            this.costPerMinute = costPerMinute;
            this.miniFarePerRide = miniFarePerRide;

        }
    }
}

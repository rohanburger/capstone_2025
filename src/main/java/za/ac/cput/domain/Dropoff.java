package za.ac.cput.domain;

/*
    Dropoff.java
    Dropoff builder Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

public class Dropoff {

    private String dropoffStreet;
    private String dropoffSuburb;
    private String dropoffCity;


    public Dropoff(DropoffBuilder builder) {

        this.dropoffStreet = builder.dropoffStreet;
        this.dropoffSuburb = builder.dropoffSuburb;
        this.dropoffCity = builder.dropoffCity;

    }

    private String getDropoffStreet() {
        return dropoffStreet;
    }

    private String getDropoffSuburb() {
        return dropoffSuburb;
    }

    private String getDropoffCity() {
        return dropoffCity;
    }

    @Override
    public String toString() {
        return "Dropoff{" +
                "dropoffStreet='" + dropoffStreet + '\'' +
                ", dropoffSuburb='" + dropoffSuburb + '\'' +
                ", dropoffCity='" + dropoffCity + '\'' +
                '}';
    }

    public static class DropoffBuilder{
        private String dropoffStreet;
        private String dropoffSuburb;
        private String dropoffCity;

        public DropoffBuilder setDropoffStreet(String dropoffStreet) {
            this.dropoffStreet = dropoffStreet;
            return this;
        }

        public DropoffBuilder setDropoffSuburb(String dropoffSuburb) {
            this.dropoffSuburb = dropoffSuburb;
            return this;
        }

        public DropoffBuilder setDropoffCity(String dropoffCity) {
            this.dropoffCity = dropoffCity;
            return this;
        }

        public Dropoff build(){
            return new Dropoff(this);
        }

    }


}

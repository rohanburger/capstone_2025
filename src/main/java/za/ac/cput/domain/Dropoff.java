package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
    Dropoff.java
    Dropoff builder Class
    Author:Sharief Abdul
    Date:08/05/2025
*/
@Entity
public class Dropoff {
    @Id
    private String dropoffId;
    private String dropoffStreet;
    private String dropoffSuburb;
    private String dropoffCity;

    public Dropoff() {}


    private Dropoff(DropoffBuilder builder) {
        this.dropoffId=builder.dropoffId;
        this.dropoffStreet = builder.dropoffStreet;
        this.dropoffSuburb = builder.dropoffSuburb;
        this.dropoffCity = builder.dropoffCity;

    }
    public String getDropoffId() {return dropoffId;}

    public String getDropoffStreet() {
        return dropoffStreet;
    }

    public String getDropoffSuburb() {
        return dropoffSuburb;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    @Override
    public String toString() {
        return "Dropoff{" +
                "dropoffId='" + dropoffId + '\'' +
                "dropoffStreet='" + dropoffStreet + '\'' +
                ", dropoffSuburb='" + dropoffSuburb + '\'' +
                ", dropoffCity='" + dropoffCity + '\'' +
                '}';
    }

    public static class DropoffBuilder{
        private String dropoffId;
        private String dropoffStreet;
        private String dropoffSuburb;
        private String dropoffCity;

        public DropoffBuilder setDropoffStreet(String dropoffStreet) {
            this.dropoffStreet = dropoffStreet;
            return this;
        }

        public DropoffBuilder setDropoffId(String dropoffId){
            this.dropoffId=dropoffId;
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

package za.ac.cput.domain;

import jakarta.persistence.*;

/*
    Dropoff.java
    Dropoff builder Class
    Author:Sharief Abdul
    Date:08/05/2025
*/
@Entity
@Table(name="DropOff")
public class Dropoff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dropoffId;
    private String dropoffStreet;
    private String dropoffSuburb;
    private String dropoffCity;

    protected Dropoff() {}


    private Dropoff(DropoffBuilder builder) {
        this.dropoffId= builder.dropoffId;
        this.dropoffStreet = builder.dropoffStreet;
        this.dropoffSuburb = builder.dropoffSuburb;
        this.dropoffCity = builder.dropoffCity;

    }
    public Long getDropoffId() {return dropoffId;}

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
        private Long dropoffId;
        private String dropoffStreet;
        private String dropoffSuburb;
        private String dropoffCity;

        public DropoffBuilder setDropoffStreet(String dropoffStreet) {
            this.dropoffStreet = dropoffStreet;
            return this;
        }

        public DropoffBuilder setDropoffId(Long dropoffId){
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

        public DropoffBuilder copy(Dropoff dropoff){
            this.dropoffId=dropoff.dropoffId;
            this.dropoffStreet=dropoff.dropoffStreet;
            this.dropoffSuburb=dropoff.dropoffSuburb;
            this.dropoffCity=dropoff.dropoffCity;
            return this;
        }

        public Dropoff build(){
            return new Dropoff(this);
        }

    }


}

package za.ac.cput.domain;

/*
    Location.java
    Location builder Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

import jakarta.persistence.*;

@Entity
@Table (name="Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dropoffId")
    private Dropoff dropoff;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pickupId")
    private Pickup pickup;

    protected Location() {
    }

    private Location(LocationBuilder builder) {
        this.locationId = builder.locationId;
        this.dropoff=builder.dropoff;
        this.pickup=builder.pickup;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Dropoff getDropoff() {
        return dropoff;
    }

    public Pickup getPickup() {
        return pickup;
    }


    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", dropoff=" + dropoff +
                ", pickup=" + pickup +
                '}';
    }

    public static class LocationBuilder{
        private Dropoff dropoff;
        private Pickup pickup;
        private Long locationId;


        public LocationBuilder setLocationId(Long locationId) {
            this.locationId = locationId;
            return this;
        }

        public LocationBuilder setDropoff(Dropoff dropoff) {
            this.dropoff=dropoff;
            return this;
        }

        public LocationBuilder setPickup(Pickup pickup) {
            this.pickup=pickup;
            return this;
        }

        public LocationBuilder copy(Location location){
            this.locationId=location.locationId;
            this.dropoff=location.dropoff;
            this.pickup=location.pickup;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
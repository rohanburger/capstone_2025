package za.ac.cput.domain;

/*
    Location.java
    Location builder Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

public class Location {

    private String locationId;
    private Dropoff dropoff;
    private Pickup pickup;





    private Location(LocationBuilder builder) {
        this.locationId = builder.locationId;
        this.dropoff=builder.dropoff;
        this.pickup=builder.pickup;
    }

    private String getLocationId() {
        return locationId;
    }

    private Dropoff getDropoff() {
        return dropoff;
    }

    private Pickup getPickup() {
        return pickup;
    }





    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' ;
    }

    public static class LocationBuilder{
        private Dropoff dropoff;
        private Pickup pickup;
        private String locationId;
        private String pickupStreet;
        private String pickupSuburb;
        private String pickupCity;
        private String dropoffStreet;
        private String dropoffSuburb;
        private String dropoffCity;

        public LocationBuilder setLocationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        public LocationBuilder setPickupStreet(String pickupStreet) {
            this.pickupStreet = pickupStreet;
            return this;
        }

        public LocationBuilder setPickupSuburb(String pickupSuburb) {
            this.pickupSuburb = pickupSuburb;
            return this;
        }

        public LocationBuilder setPickupCity(String pickupCity) {
            this.pickupCity = pickupCity;
            return this;
        }

        public LocationBuilder setDropoff(Dropoff dropoff) {
            this.dropoff=dropoff;
            return this;
        }

        public LocationBuilder getPickup() {
            this.pickup=pickup;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
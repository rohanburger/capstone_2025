package za.ac.cput.domain;

public class Location {

    private String locationId;
    private String pickupStreet;
    private String pickupSuburb;
    private String pickupCity;
    private String dropoffStreet;
    private String dropoffSuburb;
    private String dropoffCity;




    private Location(LocationBuilder builder) {
        this.locationId = builder.locationId;
        this.pickupStreet = builder.pickupStreet;
        this.pickupSuburb = builder.pickupSuburb;
        this.pickupCity = builder.pickupCity;
        this.dropoffStreet = builder.dropoffStreet;
        this.dropoffSuburb = builder.dropoffSuburb;
        this.dropoffCity = builder.dropoffCity;
    }

    private String getLocationId() {
        return locationId;
    }

    private String getPickupStreet() {
        return pickupStreet;
    }

    private String getPickupSuburb() {
        return pickupSuburb;
    }

    private String getPickupCity() {
        return pickupCity;
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
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", pickupStreet='" + pickupStreet + '\'' +
                ", pickupSuburb='" + pickupSuburb + '\'' +
                ", pickupCity='" + pickupCity + '\'' +
                ", dropoffStreet='" + dropoffStreet + '\'' +
                ", dropoffSuburb='" + dropoffSuburb + '\'' +
                ", dropoffCity='" + dropoffCity + '\'' +
                '}';
    }

    public static class LocationBuilder{
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

        public LocationBuilder setDropoffStreet(String dropoffStreet) {
            this.dropoffStreet = dropoffStreet;
            return this;
        }

        public LocationBuilder setDropoffSuburb(String dropoffSuburb) {
            this.dropoffSuburb = dropoffSuburb;
            return this;
        }

        public LocationBuilder setDropoffCity(String dropoffCity) {
            this.dropoffCity = dropoffCity;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}

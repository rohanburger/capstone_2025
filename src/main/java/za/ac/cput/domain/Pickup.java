package za.ac.cput.domain;

public class Pickup {

    private String pickupId;
    private String pickupStreet;
    private String pickupSuburb;
    private String pickupCity;


    private Pickup(Pickup.PickupBuilder builder) {
        this.pickupId = builder.pickupId;
        this.pickupStreet = builder.pickupStreet;
        this.pickupSuburb = builder.pickupSuburb;
        this.pickupCity = builder.pickupCity;

    }
    public String getPickupId() {
        return pickupId;
    }

    public String getPickupStreet() {
        return pickupStreet;
    }

    public String getPickupSuburb() {
        return pickupSuburb;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    @Override
    public String toString() {
        return "Pickup{" +
                "pickupId='" + pickupId + '\'' +
                "pickupStreet='" + pickupStreet + '\'' +
                ", pickupSuburb='" + pickupSuburb + '\'' +
                ", pickupCity='" + pickupCity + '\'' +
                '}';
    }

    public static class PickupBuilder{
        private String pickupId;
        private String pickupStreet;
        private String pickupSuburb;
        private String pickupCity;

        public Pickup.PickupBuilder setPickupId(String pickupId){
            this.pickupId = pickupId;
            return this;
        }

        public Pickup.PickupBuilder setpickupStreet(String pickupStreet) {
            this.pickupStreet = pickupStreet;
            return this;
        }

        public Pickup.PickupBuilder setPickupSuburb(String pickupSuburb) {
            this.pickupSuburb = pickupSuburb;
            return this;
        }

        public Pickup.PickupBuilder setPickupCity(String pickupCity) {
            this.pickupCity = pickupCity;
            return this;
        }

        public Pickup build(){
            return new Pickup(this);
        }

    }
}

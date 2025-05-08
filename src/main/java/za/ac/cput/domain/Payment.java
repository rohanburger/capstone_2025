package za.ac.cput.domain;
/*
    Payment.java
    Payment builder Class
    Author:Rohan Janzen Burger 230171990
    Date:19/03/2025
*/
public class Payment {
    private String paymentid;//Initialize all neccesary attributes for the Payment class
    private Float paymentamount;

    private Payment() {//Default constructor
    }

    private Payment(Builder builder) {//Constructor with he paramenter of the builder
        this.paymentid = builder.paymentid;//The Builder attributes are assigned the values from the builder pattern
        this.paymentamount = builder.paymentamount;
    }

    public String getPaymentid() {//Get method retrieving the value
        return paymentid;
    }

    public Float getPaymentamount() {
        return paymentamount;
    }

    @Override
    public String toString() {//To String displays the attribute values as a string
        return "Payment{" +
                "paymentid='" + paymentid + '\'' +
                ", paymentamount=" + paymentamount +
                '}';
    }

    public static class Builder{//Builder class contained inside of the domain class
        private String paymentid;//Attributes for the builder class
        private Float paymentamount;

        public Builder setPaymentid(String paymentid) {//Method with paramters that sets the value of the attribute ,expects a return of type builder
            this.paymentid = paymentid;
            return this;
        }

        public Builder setPaymentamount(Float paymentamount) {
            this.paymentamount = paymentamount;
            return this;
        }

        public Payment build(){//Method that returns/builds a type Payment
            return new Payment(this);
        }
    }


}

package za.ac.cput.domain;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

/*  User.java
    Passenger POJO class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 08/05/2025
*/
@Entity
@Table (name="User")
public class User {
    //private fields that stores information
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    private String userName;
    private String userSurname;
    private String userPhoneNum;
    private String userEmail;
    private String userPassword;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "userBankdetailsId")
    private BankDetails bankdetails;

    //default constructor
    protected User() {
    }

    //initialises object using PassengerBuilder
    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userSurname = builder.userSurname;
        this.userPhoneNum = builder.userPhoneNum;
        this.userEmail = builder.userEmail;
        this.userPassword=builder.userPassword;
        this.bankdetails = builder.bankdetails;
    }

    //getter methods used for access
    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public BankDetails getBankdetails() {
        return bankdetails;
    }

    //displays string representation of object and overrides

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userPhoneNum='" + userPhoneNum + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", bankdetails=" + bankdetails +
                '}';
    }

    //constructs passenger objects
    public static class UserBuilder {
        private Long userId;
        private String userName;
        private String userSurname;
        private String userPhoneNum;
        private String userEmail;
        private String userPassword;
        private BankDetails bankdetails;

        //return builder objects
        public UserBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setUserSurname(String userSurname) {
            this.userSurname = userSurname;
            return this;
        }

        public UserBuilder setUserPhoneNum(String userPhoneNum) {
            this.userPhoneNum = userPhoneNum;
            return this;
        }

        public UserBuilder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public UserBuilder setUserPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public UserBuilder setBankdetails(BankDetails bankdetails) {
            this.bankdetails = bankdetails;
            return this;
        }

        //helps update an object in repository
        public UserBuilder copy(User user) {
            this.userId = user.userId;
            this.userName = user.userName;
            this.userSurname = user.userSurname;
            this.userPhoneNum = user.userPhoneNum;
            this.userEmail = user.userEmail;
            this.userPassword = user.userPassword;
            this.bankdetails = user.bankdetails;
            return this;
        }

        //builds and returns a new passenger object
        public User build() {
            return new User(this);
        }
    }
}

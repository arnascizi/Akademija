package com.enorkus.academy.entity;

public class Customer {

    public static class CustomerBuilder {

        private String firstName;
        private String lastName;
        private String personalNumber;

        private String middleName;
        private int age;
        private String countryCode;
        private String city;
        private int monthlyIncome;
        private String employer;
        private String gender;
        private String maritalStatus;

        public CustomerBuilder(String firstName, String lastName, String personalNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.personalNumber = personalNumber;
        }

        public CustomerBuilder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public CustomerBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public CustomerBuilder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CustomerBuilder fromCity(String city) {
            this.city = city;
            return this;
        }

        public CustomerBuilder hasMonthlyIncome(int monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public CustomerBuilder hasEmployer(String employer) {
            this.employer = employer;
            return this;
        }

        public CustomerBuilder whoseGender(String gender) {
            this.gender = gender;
            return this;
        }

        public CustomerBuilder whoseMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.firstName = this.firstName;
            customer.lastName = this.lastName;
            customer.personalNumber = this.personalNumber;
            customer.middleName = this.middleName;
            customer.age = this.age;
            customer.countryCode = this.countryCode;
            customer.city = this.city;
            customer.monthlyIncome = this.monthlyIncome;
            customer.employer = this.employer;
            customer.gender = this.gender;
            customer.maritalStatus = this.maritalStatus;
            return customer;
        }
    }

    private String id;

    private String firstName;
    private String lastName;
    private String personalNumber;

    private String middleName;
    private int age;
    private String countryCode;
    private String city;
    private int monthlyIncome;
    private String employer;
    private String gender;
    private String maritalStatus;

    private Customer() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getEmployer() {
        return employer;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }
}

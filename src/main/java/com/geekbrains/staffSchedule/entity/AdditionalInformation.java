package com.geekbrains.staffSchedule.entity;

public class AdditionalInformation {
    int ID;
    String phoneNumber;
    String address;

    public AdditionalInformation() {
    }

    public AdditionalInformation(String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AdditionalInformation{" +
                "ID=" + ID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

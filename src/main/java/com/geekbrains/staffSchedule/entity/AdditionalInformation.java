package com.geekbrains.staffSchedule.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AdditionalInformation {
    @JacksonXmlProperty(localName = "id")
    private int id;
    @JacksonXmlProperty(localName = "phoneNumber")
    private String phoneNumber;
    @JacksonXmlProperty(localName = "address")
    private String address;

    public AdditionalInformation() {
    }

    public AdditionalInformation(String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getID(){
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
                "ID=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

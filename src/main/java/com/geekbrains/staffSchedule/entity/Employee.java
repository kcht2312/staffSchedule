package com.geekbrains.staffSchedule.entity;

public class Employee {
    int ID;
    String name;
    String position;
    int age;
    float salary;
    AdditionalInformation addInform;

    public Employee() {
    }

    public Employee(String name, int age, String position, float salary, AdditionalInformation addInform) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
        this.addInform = addInform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String name) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public AdditionalInformation getAddInform() {
        return addInform;
    }

    public void setAddInform(AdditionalInformation addInform) {
        this.addInform = addInform;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", addInform=" + addInform +
                '}';
    }

}

package com.geekbrains.staffSchedule.entity;

public class Employee  {
    int id;
    String name;
    String position;
    int age;
    float salary;
    AdditionalInformation addInform;

    public Employee() {
    }

    public Employee(String name, String position, int age, float salary) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, String position, int age, float salary, AdditionalInformation addInform) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
        this.addInform = addInform;
    }

    public int getID(){
        return id;
    }

    public void setID(int id) {
        this.id = id;
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
                "ID=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", addInform=" + addInform +
                '}';
    }

}

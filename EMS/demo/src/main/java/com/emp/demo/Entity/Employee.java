package com.emp.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPS")
public class Employee {
    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String address;
    private double mob;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMob() {
        return mob;
    }

    public void setMob(double mob) {
        this.mob = mob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, String address, double mob, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.salary = salary;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mob=" + mob +
                ", salary=" + salary +
                '}';
    }
}

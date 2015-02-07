package com.zhch.java8.stream;

public class Person {
    private String lastname;
    private String firstname;
    private int age;

    @Override
    public String toString() {
        return "Person [lastname=" + lastname + ", firstname=" + firstname + ", age=" + age + "]";
    }

    public Person() {
    }

    public Person(String name) {
        this.firstname = name;
    }

    public Person(String name, int age) {
        this.firstname = name;
        this.age = age;
    }
    
    public Person(Person p) {
        lastname = p.getLastname();
        this.firstname = p.getFiestname();
        this.age = p.getAge();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFiestname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

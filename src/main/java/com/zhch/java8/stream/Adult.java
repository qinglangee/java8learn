package com.zhch.java8.stream;

public class Adult extends Person{
    public Adult() {
    }

    public Adult(String name) {
        super(name);
    }

    public Adult(String name, int age) {
        super(name, age);
    }
    public Adult(Person p) {
        super(p);
    }
    
    
    public String toString(){
        return super.toString() + " [And I am Adult]";
    }
}

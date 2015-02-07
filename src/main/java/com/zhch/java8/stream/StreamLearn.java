package com.zhch.java8.stream;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * learned  from http://www.importnew.com/14908.html
 * @author lifeix
 *
 */
public class StreamLearn {
    public void forEach() {
        List<Person> persons = asList(new Person("Joe", 12), new Person("Jim", 19), new Person("John", 22));

        // 旧的迭代方式
        for (Person p : persons) {
            p.setLastname("Doe");
            System.out.println(p);
        }

        System.out.println("===================");
        // 新的迭代方式
        persons.forEach(p -> {
            p.setLastname("haha");
            System.out.println(p);
        });
        System.out.println("===================");

        // 过滤18岁以上的人
        Stream<Person> over18 = persons.stream().filter(p -> p.getAge() > 18);
        
        long over18Count = persons.stream().filter(p -> p.getAge() > 18).count();
        List<Person> personsOver18 = over18.collect(Collectors.toList());
        System.out.println("people overs 18:" + over18Count + "个");
        printPersons(personsOver18);

        // Map 18 以上的返回 Adult
        List<Adult> adults = persons.stream().filter(p -> p.getAge() > 18).map(p -> new Adult(p))
                .collect(Collectors.toList());
        System.out.println("people overs 18:");
        printPersons(adults);
        // 另一种方法
        Collection<Adult> adultsColl = persons.stream().filter(p -> p.getAge() > 18).map(p -> new Adult(p))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("people overs 18:");
        printPersons(adultsColl);
    }
    
    /**
     * 3.2顺序流与并行流
     */
    public void streamPattern(){
        List<Person> persons = new ArrayList<Person>();
        for(int i=0;i<100000;i++){
            persons.add(new Person("name" + i));
        }
        long t1 = System.currentTimeMillis();
        List <Person> people1 = persons.stream().collect(Collectors.toList());
        long t2 = System.currentTimeMillis();
        List <Person> people2 = persons.stream().parallel().collect(Collectors.toList());
        long t3 = System.currentTimeMillis();
        
        System.out.println("serialize time:" + (t2 - t1));
        System.out.println("serialize time:" + (t3 - t2));
    }

    public static void printPersons(Collection<? extends Person> persons) {
        persons.forEach(p -> {
            System.out.println(p);
        });
    }

    public static void main(String[] args) {
        StreamLearn t = new StreamLearn();
        t.streamPattern();
    }
}

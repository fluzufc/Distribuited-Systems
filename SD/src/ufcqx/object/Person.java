package src.ufcqx.object;

import java.io.Serializable;

public class Person implements Serializable {
    
    public String name;
    public Integer age;

    public Person (String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person [name = " + name + ", age: " + age + "]";
    }

}

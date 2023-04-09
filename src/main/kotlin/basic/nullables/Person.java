package basic.nullables;

import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class Person {


    public String getTitle(){
        return null;
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getTitle());
    }
}

package task2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Almat on 30.01.2020
 */
public class Task2 {

    public static void main(String[] args) {
        // Task 2. (5 points) A person stream
        System.out.println("Task 2: ");

        Comparator<Person> nameComp = Comparator.comparing(Person::getName);

        Comparator<Person> ageComp = Comparator.comparing(Person::getAge);

        Set<Person> personSet = new TreeSet<>(nameComp);
        personSet.add(new Person("bbb", 15));
        personSet.add(new Person("ccc", 10));
        personSet.add(new Person("aaa", 20));
        personSet.add(new Person("ccc", 10));


        personSet.forEach(System.out::println);

        System.out.println("------------------------------");
    }

}

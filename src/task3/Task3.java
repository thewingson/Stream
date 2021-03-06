package task3;

import java.util.*;
import java.util.function.*;

/**
 * @author Almat on 30.01.2020
 */
public class Task3 {

    public static void main(String[] args) {
        //Task 3. (10 points) Functional Interface Sandbox
        System.out.println("Task 3: ");

        User user1 = new User("asd", "asd");
        user1.setActive(true);

        User user2 = new User("sdf", "sdf");
        user2.setActive(true);

        Predicate<User> isActive = x -> x.getActive();
        System.out.println(isActive.test(user1));

        BinaryOperator<User> compare = ((u1, u2) -> (u1.getFirstName().compareTo(u2.getFirstName()) >= 0) ? u2 : u1);
        System.out.println(compare.apply(user1, user2));

        UnaryOperator<User> deactivete = user -> {
            user.setActive(false);
            return user;
        };
        deactivete.apply(user1);
        System.out.println(user1);

        Comparator<User> firstNameComp = Comparator.comparing(User::getFirstName);
        Map<User, Address> address = new TreeMap<>(firstNameComp);
        address.put(user1, new Address("Belinskogo"));
        address.put(user2, new Address("Ermekova"));
        Function<User, Address> findAddress = address::get;
        System.out.println(findAddress.apply(user2).getName());

        Consumer<User> print = user -> System.out.println("Consumer " + user);
        print.accept(user1);

        Supplier<User> userFactory = () ->{

            User user = new User();
            Scanner in = new Scanner(System.in);
            System.out.println("First name: ");
            user.setFirstName(in.nextLine());
            System.out.println("Last name: ");
            user.setLastName(in.nextLine());
            user.setActive(true);
            user.setId(3L);

            return user;

        };
        User user3 = userFactory.get();
        System.out.println("Supplier: " + user3);

        List<User> checkList = new ArrayList<>();
        checkList.add(user1);
        checkList.add(user2);
        Writer<User> writer = checkList::add;
        writer.doIt(user3);
        System.out.println(checkList);

        Writer.printW();

        System.out.println("------------------------------");
    }

}

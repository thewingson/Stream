package task4;

/**
 * @author Almat on 30.01.2020
 */
public class Task4 {

    public static void main(String[] args) {
        //Task 4. (5 points) Custom Functional Interface
        System.out.println("Task 4: ");

        System.out.println("Task 4: ");

        ThreeFunction<Integer> max = (x, y, z) -> {

            Integer m = x;
            if(y > m){
                m = y;
            }
            if(z > m){
                m = z;
            }

            return m;

        };

        System.out.println(max.compare(5, 7, 9));

        System.out.println("------------------------------");
    }

}

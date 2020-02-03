package task7;

import java.util.Arrays;
import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        //Task 7
        System.out.println("Task 7: ");

        List<Integer> integers = Arrays.asList(88, 2, 3, 14);
        System.out.println(integers);

        System.out.println(integers
                .stream()
                .collect(new IntCollector()).getClass());

        //        Integer res = integers
//                .stream()
//                .collect(Collector.of(
//                        () -> new Integer[]{0},
//                        (result, article) -> result[0] += article,
//                        (result11, result22) -> {
//                            result11[0] += result22[0];
//                            return result11;
//                        },
//                        total -> total[0],
//                        Collector.Characteristics.CONCURRENT,
//                        Collector.Characteristics.IDENTITY_FINISH
//                ));

//        System.out.println("Result: " + res);

        System.out.println("------------------------------");

    }

}

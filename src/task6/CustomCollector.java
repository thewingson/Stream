package task6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

public class CustomCollector {

    public static <T> Collector<T, Set<T>, List<T>> unique() {
        return Collector.of(
                HashSet::new,
                Set::add,
                (result1, result2) -> {
                    result1.addAll(result2);
                    return result1;
                },
                ArrayList::new,
                Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.UNORDERED);
    }
}
package task7;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class IntCollector implements Collector<Integer, Integer[], Integer> {

    @Override
    public Supplier<Integer[]> supplier() {
        return  () -> new Integer[]{0};
    }

    @Override
    public BiConsumer<Integer[], Integer> accumulator() {
        return (result, value) -> result[0] += value;
    }

    @Override
    public BinaryOperator<Integer[]> combiner() {
        return (result1, result2) -> {
            result1[0] += result2[0];
            return result1;
        };
    }

    @Override
    public Function<Integer[], Integer> finisher() {
        return total -> total[0];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>(Arrays.asList(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}

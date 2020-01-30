package task6;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GameCollector implements Collector<Player, List<Player>, List<Player>> {

    private int teamSize;

    public GameCollector(int bucketSize) {
        this.teamSize = teamSize;
    }

    @Override
    public Supplier<List<Player>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Player>, Player> accumulator() {
        return (list, val) -> {
            if(val.getAvailability() && (val.getMood().equals(Mood.CHARGED) || val.getMood().equals(Mood.HIGH)) && val.getCondition() > 50){
                list.add(val);
            }
        };
    }

    @Override
    public BinaryOperator<List<Player>> combiner() {
        return null;
    }

    @Override
    public Function<List<Player>, List<Player>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>(Arrays.asList(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public static GameCollector buildUp(int teamSize) {
        return new GameCollector(teamSize);
    }
}

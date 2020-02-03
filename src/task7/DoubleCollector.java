package task7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DoubleCollector implements Collector<Double, Double[], Double> {

    private Method method;
    private Boolean checkStarted;
    private Integer size;

    public DoubleCollector(Method method, Integer size) {
        this.method = method;
        this.size = size;
        checkStarted = false;
    }

    @Override
    public Supplier<Double[]> supplier() {
        return () -> new Double[]{0.0};
    }

    @Override
    public BiConsumer<Double[], Double> accumulator() {
        return (result, value) -> {
            switch (this.method){
                case SUM:
                    sum(result, value);
                    break;
                case CNT:
                    count(result);
                    break;
                case AVG:
                    average(result, value);
                    break;
                case MIN:
                    min(result, value);
                    break;
                case MAX:
                    max(result, value);
                    break;
            }
        };
    }

    @Override
    public BinaryOperator<Double[]> combiner() {
        return (result1, result2) -> {
            switch (this.method){
                case MIN:
                    if(result1[0] < result2[0]){
                        return result1;
                    } else{
                        return result2;
                    }

                case MAX:
                    if(result1[0] > result2[0]){
                        return result1;
                    } else{
                        return result2;
                    }
                default:
                    result1[0] += result2[0];
                    return result1;
            }
        };
    }

    @Override
    public Function<Double[], Double> finisher() {
        return total -> total[0];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>(Arrays.asList(Characteristics.CONCURRENT));
    }

    private Double sum(Double[] result, Double value){
        return result[0] += value;
    }

    private Double count(Double[] result){
        return result[0] ++;
    }

    private Double min(Double[] result, Double value){
        if (!checkStarted){
            result[0] = value;
            checkStarted = true;
        } else if (value < result[0]){
            result[0] = value;
        }
        return result[0];
    }

    private Double max(Double[] result, Double value){
        if (!checkStarted){
            result[0] = value;
            checkStarted = true;
        } else if (value > result[0]){
            result[0] = value;
        }
        return result[0];
    }

    private Double average(Double[] result, Double value){
        return result[0] += value/size;
    }
}

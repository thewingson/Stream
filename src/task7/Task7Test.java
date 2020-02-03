package task7;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.round;

public class Task7Test {


    @Test
    public void main() throws Exception {

        List<Double> doubles = Arrays.asList(2.7, 12.6, 11.1, 41.2);

        Double avg = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.AVG, doubles.size()));

        Double max = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.MAX, doubles.size()));

        Double expAvg = 16.9;
        Double expMax = 41.2;

        DecimalFormat df = new DecimalFormat("#.#");

        Assert.assertEquals(df.format(expAvg), df.format(avg));
        Assert.assertEquals(df.format(expMax), df.format(max));

    }
}
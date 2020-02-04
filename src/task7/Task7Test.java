package task7;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Task7Test {


    @Test
    public void main() throws Exception {

        List<Double> doubles = Arrays.asList(-2.7, -12.6, -11.1, -41.2);
        Double avg = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.AVG, doubles.size()));
        Double max = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.MAX, doubles.size()));
        Double min = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.MIN, doubles.size()));
        Double sum = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.SUM, doubles.size()));
        Double count = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.CNT, doubles.size()));
        Double expAvg = 16.9;
        Double expMax = 41.2;
        Double expMin = 2.7;
        Double expSum = 67.6;
        Double expCount = 4.0;
        DecimalFormat df = new DecimalFormat("#.##");
        Assert.assertEquals(df.format(expAvg), df.format(avg));
        Assert.assertEquals(df.format(expMax), df.format(max));
        Assert.assertEquals(df.format(expMin), df.format(min));
        Assert.assertEquals(df.format(expSum), df.format(sum));
        Assert.assertEquals(df.format(expCount), df.format(count));

        doubles = Arrays.asList(2.5, 12.5, 9.5, 14.5);
        avg = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.AVG, doubles.size()));

        max = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.MAX, doubles.size()));
        min = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.MIN, doubles.size()));
        sum = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.SUM, doubles.size()));
        count = doubles
                .stream()
                .parallel()
                .collect(new DoubleCollector(Method.CNT, doubles.size()));
        expAvg = 9.75;
        expMax = 14.5;
        expMin = 2.5;
        expSum = 39.0;
        expCount = 4.0;

        Assert.assertEquals(df.format(expAvg), df.format(avg));
        Assert.assertEquals(df.format(expMax), df.format(max));
        Assert.assertEquals(df.format(expMin), df.format(min));
        Assert.assertEquals(df.format(expSum), df.format(sum));
        Assert.assertEquals(df.format(expCount), df.format(count));

    }
}
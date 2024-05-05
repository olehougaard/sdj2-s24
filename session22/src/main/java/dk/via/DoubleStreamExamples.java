package dk.via;

import java.util.Optional;
import java.util.Random;
import java.util.stream.DoubleStream;

public class DoubleStreamExamples {
    public static void main(String[] args) {
        Random random = new Random();
        double[] randomNumbers = DoubleStream.generate(random::nextDouble).limit(1000).toArray();

        double average = DoubleStream.of(randomNumbers).average().orElse(0);

        double wrongDeviation = DoubleStream.of(randomNumbers)
                .map(n -> n - average)
                .average()
                .orElse(0);
        System.out.println(wrongDeviation);

        double deviation  = DoubleStream.of(randomNumbers)
                .map(n -> n - average)
                .map(Math::abs)
                .average()
                .orElse(0);
        System.out.println(deviation);

        double variance  = DoubleStream.of(randomNumbers)
                .map(n -> n - average)
                .map(n -> n * n)
                .average()
                .orElse(0);
        System.out.println(variance);

        double standardDeviation = Math.sqrt(variance);
        System.out.println(standardDeviation);
    }
}

package com.company;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class EntryFrequency {

    private static Map<Character, BigDecimal> preFrequency = new HashMap<>();

    public static void main(String[] args) throws IOException {
        printFr("K:\\University\\CA2\\ConsoleApplication2\\ConsoleApplication2\\bin\\Debug\\out.txt");
    }

    private static TreeMap<Character, BigDecimal> statistic(String filename) throws IOException {
        try(Stream<String> stream = Files.lines(Paths.get(filename))){
            stream.forEach(EntryFrequency::count);
        }
        BigDecimal sum = preFrequency.values().stream().reduce(BigDecimal::add).orElse(BigDecimal.ONE);
        preFrequency.entrySet().forEach(entry -> entry.setValue((entry.getValue()
                .multiply(new BigDecimal(100))
                .divide(sum, new MathContext(2, RoundingMode.HALF_UP)))));
        return new TreeMap<>(preFrequency);
    }

    private static void count(String line){
        char[] array = line.toLowerCase().replaceAll("[^a-zA-Z]", "").toCharArray();
        for (char ch : array) {
            if(preFrequency.containsKey(ch)) preFrequency.put(ch, preFrequency.get(ch).add(BigDecimal.ONE));
            else preFrequency.put(ch, BigDecimal.ONE);
        }
    }

    static void printFr(String filename){
        try {
            TreeMap<Character, BigDecimal> statistic =
                    EntryFrequency.statistic(filename);
            statistic.forEach((k, d) -> System.out.println("letter: " + k + " frequency: " + d + "%"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

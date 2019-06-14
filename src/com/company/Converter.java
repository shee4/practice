package com.company;

import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;

public class Converter {

    public static Map<Pair<String, String>, Function<Double, Double>> coefficient = new HashMap<>();
    static final List<String> values = Arrays.asList("ruble", "dollar", "celsius", "kelvin", "meter", "foot",
            "kg", "lb", "liter", "pint", "fahrenheit", "ms", "kmh");

    public static void main(String[] args) {
        coefficient.put(new Pair<>("ruble", "dollar"), (r) -> 60 / r);
        coefficient.put(new Pair<>("dollar", "ruble"), (d) -> d * 60);
        coefficient.put(new Pair<>("celsius", "kelvin"), c -> c + 273);
        coefficient.put(new Pair<>("kelvin", "celsius"), k -> k - 273);
        coefficient.put(new Pair<>("meter", "foot"), m -> m * 3.28);
        coefficient.put(new Pair<>("foot", "meter"), f -> f / 3.28);
        coefficient.put(new Pair<>("kg", "lb"), kg -> kg * 2.2);
        coefficient.put(new Pair<>("lb", "kg"), f -> f / 2.2);
        coefficient.put(new Pair<>("liter", "pint"), l -> l * 1.7);
        coefficient.put(new Pair<>("pint", "liter"), p -> p / 1.7);
        coefficient.put(new Pair<>("euro", "dollar"), e -> e * 1.2);
        coefficient.put(new Pair<>("dollar", "euro"), d -> d / 1.2);
        coefficient.put(new Pair<>("celsius", "fahrenheit"), c -> (c * 2) + 32);
        coefficient.put(new Pair<>("fahrenheit", "celsius"), f -> (f - 32) * 0.5);
        coefficient.put(new Pair<>("ruble", "euro"), r -> r * 70);
        coefficient.put(new Pair<>("euro", "ruble"), e -> e / 70);
        coefficient.put(new Pair<>("kelvin", "fahrenheit"), k -> (k - 273) * 2 + 32);
        coefficient.put(new Pair<>("fahrenheit", "kelvin"), f -> (f - 32) * 0.5 + 273);
        coefficient.put(new Pair<>("ms", "kmh"), ms -> ms * 3.6);
        coefficient.put(new Pair<>("kmh", "ms"), kh -> kh / 3.6);

        Scanner scan = new Scanner(System.in);
        String[] s = new String[2];
        Pair<String, String> pair;

        System.out.print("available types to convert: ");
        for (String str: values) System.out.print(str + " | ");
        System.out.println();

        while (true){
        System.out.println("select types to convert: ");

        s = scan.nextLine().toLowerCase().split("[^a-z]+");

        if(!values.contains(s[0]) || !values.contains(s[1])) {
            System.out.println("wrong values, please try again");
            continue;
        }

        pair = new Pair<>(s[0], s[1]);
        if(coefficient.containsKey(pair))
            break;
        else
            System.out.println("correct values, but convertation is impossible - wrong pair of values, please try again");
        }

        System.out.println("Enter numeric value to convert: ");
        Double v = (double) scan.nextInt();

        double res = coefficient.get(pair).apply(v);
        System.out.println(res + " " + s[1] + " in " + s[0]);

    }

}

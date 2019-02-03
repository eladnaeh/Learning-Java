package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();

//        someBingoNumbers.forEach(number -> {
////            if(number.toUpperCase().startsWith("G")){
////                gNumbers.add(number);
//////                System.out.println(number);
////            }
////        });
////
////        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
////        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers.stream().map(String::toUpperCase).filter(s->s.startsWith("G")).sorted().forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNUmberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");

        //joining 2 streams toghther
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNUmberStream);
        System.out.println("----------------------------------");

        //printing number of distinct elements with terminate operation
//        System.out.println(concatStream.distinct().count());

        //printing the numbers and the number of elements of distinct elements using itermidiate operation(peek())
        System.out.println(concatStream.distinct().peek(System.out::println).count());


    }
}

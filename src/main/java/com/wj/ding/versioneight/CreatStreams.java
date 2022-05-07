package com.wj.ding.versioneight;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @date 2022/3/20 14:56
 * @author: wj
 */
public class CreatStreams {

    public static void main(String[] args) {
        testFlatMap();
    }

    private static void testFlatMap(){
        List<String> wordList = Arrays.asList("gently", "down", "the", "stream");
        Map<Integer, Long> map = wordList.parallelStream().collect(groupingBy(String::length, counting()));
        System.out.println(map);

        Stream<String> words = Stream.of("gently", "down", "the", "stream");
        words.forEach(System.out::println);
        words.forEachOrdered(System.out::println);
        Stream<Stream<String>> letterStream = words.map(CreatStreams::letters);
        letterStream.forEach(System.out::println);
        Stream<String> flatMapStream = words.flatMap(CreatStreams::letters);
        flatMapStream.forEach(System.out::println);
        Stream<Locale> locales = Arrays.stream(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));
        System.out.println(countryToLocales);

    }

    private static Stream<String> letters(String s){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i+1));
        }
        return result.stream();
    }

    private static void testCreateStream(){
        Stream<String> words = Stream.of("gently", "down", "the", "stream");
        words.forEach(System.out::println);

        Stream<Double> random = Stream.generate(Math::random).limit(2);
        random.forEach(System.out::println);

        BigInteger one = BigInteger.ONE;
        System.out.println(one);

        IntStream intStream = IntStream.range(0, 10);
        intStream.forEach(System.out::println);
    }

}

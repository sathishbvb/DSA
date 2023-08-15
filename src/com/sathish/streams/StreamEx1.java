package com.sathish.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamEx1 {
    public static void main(String[] args) {
        StreamEx1 s = new StreamEx1();
//        s.getAverage(Arrays.asList(1,2,3,4,5,6));
//        s.oddEvenCount(Arrays.asList(1,2,3,4,5,6));
//        Function<String,String> toUpperFunction = String::toUpperCase;
//        Function<String,String> toLowerFunction = String::toLowerCase;
//        s.changeCharCase(Arrays.asList("a","s","A","s"),toLowerFunction);
//        s.changeCharCase(Arrays.asList("a","s","A","s"),toUpperFunction);
//        s.removeDuplicates(Arrays.asList(1,1,1,2,3,4,4,5));
//        s.countOfStringInList(Arrays.asList("sas","Satsf","sadawef"));
//        s.countStartWithSpecificChar(Arrays.asList("sas","Satsf","adawef"));
//        s.sortList(Arrays.asList("z","a","b"));
        s.maxMinValue(Arrays.asList(1,2,3,4,5,6));
    }

    void getAverage(List<Integer> list){
        Double d = list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println(d);
    }
    void changeCharCase(List<String> list, Function<String,String>  function){
        list.stream().map(function).toList().forEach(System.out::println);
    }

    void oddEvenCount(List<Integer> list){
        Integer sum = list.stream().filter(val -> val % 2 == 0).mapToInt(Integer::intValue).sum();
        Integer sum1 = list.stream().filter(val -> val % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("The even sum is {"+sum+"} odd sum is {"+sum1+"}");
    }

    void removeDuplicates(List<Integer> list){
        list.stream().distinct().toList().forEach(System.out::println);
    }

    void countOfStringInList(List<String> list){
        list.stream().map(String::length).toList().forEach(System.out::println);
    }

    void countStartWithSpecificChar(List<String> list){
        list.stream().filter(val->val.startsWith("s")||val.startsWith("S")).toList().forEach(System.out::println);
    }

    void sortList(List<String> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    void maxMinValue(List<Integer> list){
        list.stream().distinct().sorted().skip(1).findFirst().ifPresent(System.out::println);
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
    }
}

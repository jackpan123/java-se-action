package com.jackpan.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterTest {


    public List<Apple> filterApples(List<Apple> apples) {
        List<Apple> redApples = new ArrayList<>();
        for (Apple apple : apples) {
            if (Apple.Color.RED.equals(apple.getColor())) {
                redApples.add(apple);
            }
        }

        return redApples;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                resultList.add(t);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        AppleFilterTest.filter(apples, apple -> Apple.Color.RED.equals(apple.getColor()));

        List<Apple> oranges = new ArrayList<>();

        AppleFilterTest.filter(oranges, orange -> orange.getWeight() > 50);

    }
}

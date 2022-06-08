package com.jiangcheng1806.practice.java8.stream.testcase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：jiangcheng
 * @version : 1.0.0
 * @description ：TODO
 * @date ： 2022/6/8 21:16
 */
public class TestTask {

    private static Gson gson = new Gson();
    public static void testList2Map(List<Apple> appleList){

        System.out.println("testList2Map");;
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key .... *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1, k2)->k1));

        System.out.println(gson.toJson(appleMap));


    }

    public static void testList2GrouBy(List<Apple> appleList) {


        System.out.println("testList2GrouBy");;
        /**
         */
        Map<Integer, List<Apple>> appleMap = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.out.println(gson.toJson(appleMap));
    }

    public static void testListFilter(List<Apple> appleList) {

        System.out.println("testListFilter");;
        /**
         */
        List<Apple> filteredList = appleList.stream().filter(apple -> apple.getMoney().compareTo(new BigDecimal("2.89"))>0).collect(Collectors.toList());

        System.out.println(gson.toJson(filteredList));
    }

    public static void testDecimalSum(List<Apple> appleList) {

        System.out.println("testDecimalSum");;
        /**
         */
        BigDecimal decimalSum = appleList.stream().map(apple -> apple.getMoney()).reduce(BigDecimal.ZERO,BigDecimal::add);

        System.out.println(gson.toJson(decimalSum));
    }


    public static void testCountDigits(List<Apple> appleList) {

        System.out.println("testCountDigits");;
        /**
         */
        int total = appleList.stream().mapToInt(apple -> apple.getNum()).sum();

        System.out.println(gson.toJson(total));
    }

}

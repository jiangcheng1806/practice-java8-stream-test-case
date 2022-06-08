package com.jiangcheng1806.practice.java8.stream.testcase;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：jiangcheng
 * @version : 1.0.0
 * @description ：TODO
 * @date ： 2022/6/8 21:15
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        System.out.println(new Gson().toJson(appleList));;

        TestTask.testList2Map(appleList);

        TestTask.testList2GrouBy(appleList);

        TestTask.testListFilter(appleList);

        TestTask.testDecimalSum(appleList);

        TestTask.testCountDigits(appleList);
    }
}

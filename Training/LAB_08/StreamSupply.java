package p0713_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamSupply{
    public static void main(String [] args){
        List<String> names = Arrays.asList("james","tom","joy","vivian");
//        for(String name:names){
//            System.out.println(name);
//        }

/*  
    Functional Interface
        Consumer
        Predicate
        Supplier
        Function
    ref : https://openhome.cc/Gossip/Java/ConsumerFunctionPredicateSupplier.html
*/

/*
        Consumer consumer = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        names.forEach(consumer);
        names.forEach(s->System.out.println(s)); //Consumer 給一個引數沒有回傳值 ref java8 api
        names.forEach(System.out::println);
*/

/*
        names.stream().filter(a->{              //predicate 給一個引數回傳布林值 ref java 8 api
            boolean b = a.startsWith("j");
            return b;
        }).forEach(System.out::println);
*/

/*
        0-100亂數
        IntStream.generate(()->new Random().nextInt(101)).limit(10).forEach(System.out::println);
        int [] intArray = new Random().ints(10,0,100).toArray();
        IntStream.of(intArray).forEach(System.out::println);
*/

        //Homework
        //不及格分數加10%，求總分平均
        int [] scores = {90,80,40,30};
        
        double sum = IntStream.of(scores).mapToDouble(s->{
                                        double c = s; 
                                        if(c<60){
                                            c = s*1.1;
                                        }
                                        return c;
                                      }).sum();
        System.out.println("sum : " +sum);
        double avg = IntStream.of(scores).mapToDouble(s->{
                                        double c = s; 
                                        if(c<60){
                                            c = s*1.1;
                                        }
                                        return c;
                                      }).average().getAsDouble();
        System.out.println("avg : " +avg);
        //也可以使用三元運算子
        double sum2 = IntStream.of(scores).mapToDouble(s->s<60?s*1.1:s).sum();
        double avg2 = IntStream.of(scores).mapToDouble(s->s<60?s*1.1:s).average().getAsDouble();
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamTest {
    public static void main(String []args){
        /*
            lambda express foreach
        */
        List<String> names = Arrays.asList("tom","james","vivian","joe");
//        for(String name : names){
//            System.out.println(name);
//        }
        //names.forEach(s->System.out.println(s));
        //names.forEach(System.out::println);
       
        /*
            String List filter map collect
        */
        
        //filter
        //names.stream().filter(s->s.startsWith("j")).forEach(System.out :: println);
        
        //map
        //names.stream().map(s->s.toUpperCase()).forEach(System.out::println);
        
        //collect
        //List<Integer> lens = names.stream().map(s->s.length()).collect(Collectors.toList());
        //List<String> names2 = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        
        //Question:請將j開頭的名字篩選出來並轉換成字串長度存成List<Inlteger> names_length並列印出來
        //List<Integer> names_len = names.stream().filter(s->s.startsWith("j")).map(String::length).collect(Collectors.toList());
        //names_len.forEach(System.out::println);
        
        
        /*
            Integer List collect map max average sorted
        */
        //generate number list
        //List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        
        double avg = IntStream.rangeClosed(1, 10).average().getAsDouble();
        //System.out.println(avg);
        int sum = numbers.stream().mapToInt(s->s.intValue()).sum();
        //System.out.println(sum);
        int max = numbers.stream().mapToInt(s->s.intValue()).max().getAsInt();
        //System.out.println(max);
        
        //Question：計算1-100之間的偶數和
        //System.out.println("even_sum：" + IntStream.rangeClosed(1, 100).filter(s->s%2==0).sum());
        
        //sorted
        List<Integer> numbers2 = Arrays.asList(3,4,5,1,2);
        //numbers2.stream().sorted().forEach(System.out::println);
        //numbers2.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        
        //Object List 
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("2330","台積電","電子",7533,240.5));
        stocks.add(new Stock("2317","鴻海","電子",6123,80.5));
        stocks.add(new Stock("2890","永豐金","金融",3012,11.05));
        stocks.add(new Stock("2885","元大金","金融",3000,14.01));
        stocks.add(new Stock("1301","台塑","傳產",4500,106));
        stocks.add(new Stock("1707","葡萄王","傳產",3000,239.0));
        //找出電子股中股價最高的
        double priceMax= stocks.stream().filter(s->s.getType().equals("電子")).mapToDouble(Stock::getPrice).max().getAsDouble();
        stocks.stream().filter(s->s.getPrice()== priceMax).forEach(s->System.out.println(s.getStkName()));
        
        //找出成交金額最高
        double stockValueMax = stocks.stream().mapToDouble(s->s.getVolumne()*s.getPrice()).max().getAsDouble();
        stocks.stream().filter(s->s.getType().equals("電子")).map(Stock::getPrice).collect(Collectors.toList());
        
        //排序
        List<Stock> stocks_order =stocks.stream().sorted(Comparator.comparing(s->s.getVolumne())).collect(Collectors.toList());
        stocks_order.forEach(s->System.out.println(s.getStkName()+"\t"+s.getVolumne()));
        //ditinct
        stocks.stream().map(s->s.getType()).distinct().forEach(System.out::println);
        
        //Question：計算金融股交易均量
       double finAvgVol =  stocks.stream().filter(s->s.getType().equals("金融")).mapToInt(Stock::getVolumne).average().getAsDouble();
       System.out.println(finAvgVol);
       
       stocks.stream().limit(3).forEach(s->System.out.println(s.getStkName()));
    }
}

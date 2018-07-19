

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class FundTest {
    public static void main(String[] args){
        List<Fund> list = new ArrayList();
        Fund fund1 = new Fund("XX中小基金");
        fund1.addStock(new Stock("2327","國巨",113_783_625.0));
        fund1.addStock(new Stock("2330","台積電",43_300_000.0));
        fund1.addStock(new Stock("2317","鴻海",17_960_000.0));
        Fund fund2 = new Fund("XX高科技基金");
        fund1.addStock(new Stock("2327","國巨",51_964_875.0));
        fund1.addStock(new Stock("2330","台積電",36_300_000.0));
        fund1.addStock(new Stock("2492","華新科",45_870_000.0));
        Fund fund3 = new Fund("XX領航科技基金");
        fund1.addStock(new Stock("3008","大立光",31_964_875.0));
        fund1.addStock(new Stock("2330","台積電",22_300_000.0));
        fund1.addStock(new Stock("2890","永豐金",30_000_000.0));
        list.add(fund1);
        list.add(fund2);
        list.add(fund3);
        
        //list.forEach(s->System.out.println(s.getFundName()));
        list.stream().map(s->s.getProtfolio())//Stream<Set<Stock>>
                     .flatMap(x->x.stream()) //Stream<Stock>
                     .map(s->s.getStkName())
                     .distinct()
                     .forEach(System.out::println);
        double sum=0;
        //Map<String,Double> list2 = list.stream().collect(groupingBy(Fund::getFundName),summingDouble(Fund::getProtfolio::Stock::getMktValue))) ;
        //List<Integer> list3 = Arrays.asList(2,3,5,1,4);
        //list3.stream().sorted().forEach(System.out::println);
        System.out.println("----------");
        //Double sum = list.stream().map(s->s.getProtfolio()).flatMap(x->x.stream()).mapToDouble(s->s.getMktValue()).sum();
        //Double sum2 = list.stream().filter(s->s.getFundName().equals("永豐領航科技基金")).flatMap(s->s.getProtfolio().stream()).mapToDouble(s->s.getMktValue()).sum();
        //System.out.println(sum2);
        list.stream().filter(s->s.getFundName().equals("永豐高科技基金")).flatMap(s->s.getProtfolio().stream()).forEach(s->System.out.println(s.getMktValue()));
        Map<String,Double> stkSum = list.stream().flatMap(s->s.getProtfolio().stream()).collect(groupingBy(Stock::getStkCode, summingDouble(Stock::getMktValue)));
        stkSum.forEach((k,v)->System.out.println(k+" : "+v));
    }   
}

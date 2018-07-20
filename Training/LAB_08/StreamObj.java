import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class FundTest {
    public static void main(String[] args){
        List<Fund> list = new ArrayList();
        Fund fund1 = new Fund("XX中小基金");
        fund1.addStock(new Stock("2327","國巨",30_000_000.0));
        fund1.addStock(new Stock("2330","台積電",30_000_000.0));
        fund1.addStock(new Stock("2317","鴻海",50_000_000.0));
        Fund fund2 = new Fund("XX高科技基金");
        fund2.addStock(new Stock("2327","國巨",30_000_000.0));
        fund2.addStock(new Stock("2330","台積電",40_000_000.0));
        fund2.addStock(new Stock("2492","華新科",50_000_000.0));
        Fund fund3 = new Fund("XX領航科技基金");
        fund3.addStock(new Stock("3008","大立光",30_000_000.0));
        fund3.addStock(new Stock("2330","台積電",40_000_000.0));
        fund3.addStock(new Stock("2890","永豐金",50_000_000.0));
        list.add(fund1);
        list.add(fund2);
        list.add(fund3);
        //顯示所有基金名稱
        list.forEach(s->System.out.println(s.getFundName()));
        System.out.println("----------");
        //顯示所有股票清單
        list.stream().map(s->s.getProtfolio())//Stream<Set<Stock>>
                     .flatMap(x->x.stream()) //Stream<Stock>
                     .map(s->s.getStkName())
                     .distinct()
                     .forEach(System.out::println);
        
        System.out.println("----------");
        
        //groupby stkcode
        //list.stream().filter(s->s.getFundName().equals("XX高科技基金")).flatMap(s->s.getProtfolio().stream()).forEach(s->System.out.println(s.getMktValue()));
        Map<String,Double> stkSum = list.stream().flatMap(s->s.getProtfolio().stream()).collect(groupingBy(Stock::getStkCode, summingDouble(Stock::getMktValue)));
        stkSum.forEach((k,v)->System.out.println(k+" : "+v));
        System.out.println("----------");
        
        //計算基金總合
        //Double sum = list.stream().map(s->s.getProtfolio()).flatMap(x->x.stream()).mapToDouble(s->s.getMktValue()).sum();
        Double sum = list.stream().filter(s->s.getFundName().equals("XX領航科技基金")).flatMap(s->s.getProtfolio().stream()).mapToDouble(s->s.getMktValue()).sum();
        System.out.println(sum); 
    }   
}


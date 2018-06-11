
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawler {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://tw.stock.yahoo.com/q/q?s=2317").get();
        //System.out.println(doc.select("td[nowrap]").html());
        //System.out.println(doc.select("td[nowrap]").outerHtml());
        System.out.println(doc.select("td[nowrap]").text());
        String [] dataArray = doc.select("td[nowrap]").text().split(" ");
        System.out.println(dataArray[2]);
        System.out.println("2330:"+getStkPrice("2330"));
        System.out.println("2498:"+getStkPrice("2498"));
        System.out.println(String.format("%02d", 1));
    }
  
    public static String getStkPrice(String symbol) throws IOException{   
        Document doc = Jsoup.connect("https://tw.stock.yahoo.com/q/q?s="+symbol).get();
        String [] dataArray = doc.select("td[nowrap]").text().split(" ");
        String stkPrice = dataArray[2];
        return stkPrice;
    }
}

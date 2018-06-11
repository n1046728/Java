import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawler {
    public static void main(String [] args) throws IOException{
//        Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx?area=10").get();
//        System.out.println(doc.select("#ctl08_gv_ctl04_linkSite").text());
//        System.out.println(doc.select("#ctl08_gv_ct104_lab1").text());
        System.out.println(getPM25ByArea("123456"));
       
    }
    public static String getPM25ByArea(String area) throws IOException{
        String pm =null;
        Map<String,String> map =new HashMap<>();
        Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx?area=10").get();
        
        for(int i =2;i<=99;i++){
            String text = doc.select("#ctl08_gv_ctl"+String.format("%02d", i)+"_linkSite").text();
            //System.out.println("#ctl08_gv_ctl"+String.format("%02d", i)+"_linkSite");
            if(!text.isEmpty()){
                map.put(text,"ctl08_gv_ctl"+String.format("%02d", i)+"_lab1");
            }     
        }
//        for (Entry<String, String> entry : map.entrySet()) {
//            System.out.print(entry.getKey()+"\t");
//            System.out.println(entry.getValue());
//        } 
        pm = map.get("萬里");
        System.out.println(doc.select("#ctl08_gv_ctl04_lab1").text());
        System.out.println(map.get("萬里")+":"+doc.select("#"+pm).text());
        System.out.println(pm);
        System.out.println(doc.select(pm).text());
        
        return doc.select(pm).text();
    }
}

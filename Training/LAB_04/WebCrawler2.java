import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawler2 {
    public static void main(String [] args) throws IOException{
        Map<String,String> map= getMap();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.next());
        while(true){
            System.out.println("請輸入以下其中一個區域查詢PM2.5，不輸入按ENTER可離開");
            System.out.println(map.keySet());
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.next());
            String input = scanner.next();
            if(input.isEmpty()){
               break; 
            }else{
                System.out.println(input+"現在的PM2.5為："+getPM25ByArea(input));
                input=null;
            }
        }
    }
    public static String getPM25ByArea(String area) throws IOException{
        String pm =null;
        Map<String,String> map= getMap();
        Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx?area=10").get();
//        for (Entry<String, String> entry : map.entrySet()) {
//            System.out.print(entry.getKey()+"\t");
//            System.out.println(entry.getValue());
//        } 
        pm = doc.select("#"+map.get(area)).text();
//        System.out.println(doc.elect("#ctl08_gv_ctl04_lab1").text());
//        System.out.println(map.get("萬里")+":"+doc.select("#"+pm).text());
//        System.out.println(pm);
//        System.out.println(doc.select(pm).text());
        
        return pm;
    }
    
    public static Map<String,String> getMap() throws IOException{
        Map<String,String> map =new HashMap<>();
        Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx?area=10").get();
        for(int i =2;i<=99;i++){
            String text = doc.select("#ctl08_gv_ctl"+String.format("%02d", i)+"_linkSite").text();
            //System.out.println("#ctl08_gv_ctl"+String.format("%02d", i)+"_linkSite");
            if(!text.isEmpty()){
                map.put(text,"ctl08_gv_ctl"+String.format("%02d", i)+"_lab1");
            }     
        }
        return map;
    }
}


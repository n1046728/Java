import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawler2 {
    public static void main(String [] args) throws IOException{
    	Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx?area=10").get();
    	Map<String,String> map= getMap();

        while(true){
            System.out.println("請輸入以下其中一個區域查詢PM2.5，輸入非下述區域會離開...");
            System.out.println(map.keySet());
            System.out.print("請輸入：");
            Scanner scanner = new Scanner(System.in);
            //Scanner scanner = new Scanner(System.in,"UTF-8"); //IDE NetBeans
            String input = scanner.next();
            
            if(map.containsKey(input)){
            	System.out.println("find pm2.5中...請稍候");
                System.out.println(input+"現在的PM2.5即時濃度為："+doc.select("#"+map.get(input)).text());
                System.out.println();
            }else{
            	System.out.println("離開...");
            	break; 
            }
        }
    }
 
    //將地區名稱與對應的即時濃度css id做成map供查找對映
    public static Map<String,String> getMap() throws IOException{
        Map<String,String> map =new HashMap<>();
        Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx?area=10").get();
        for(int i =2;i<=99;i++){
        	//area css_id
            //<a id="ctl08_gv_ctl02_linkSite" href="http://taqm.epa.gov.tw/taqm/tw/Site/Keelung.aspx" target="_blank">基隆</a>
            String text = doc.select("#ctl08_gv_ctl"+String.format("%02d", i)+"_linkSite").text();
            if(!text.isEmpty()){
            	//pm2.5 value
            	//<span id="ctl08_gv_ctl02_lab1">26</span>
                map.put(text,"ctl08_gv_ctl"+String.format("%02d", i)+"_lab1");
            }     
        }
        return map;
    }
}

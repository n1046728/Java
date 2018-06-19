import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*------------------------------------------------
    建立static區域將地區與對映的pm2.5值存入map以供查找
-------------------------------------------------*/
public class PM25LAB {
    public static HashMap<String,Integer> pm25Map=new HashMap<>();
    
    static{
        try{
            Document doc = Jsoup.connect("https://taqm.epa.gov.tw/pm25/tw/PM25A.aspx").get();

            for(int i=1;i<=27;i++){
                String areaCssQuery =String.format("#ctl08_gv_ctl%02d_linkSite", i);
                String pm25CssQuery =String.format("#ctl08_gv_ctl%02d_lab1", i);
                //i若不足兩位數則補零 ex. i=1 => 01
                //System.out.println(String.format("%02d", i));
                String area= doc.select(areaCssQuery).text().trim();
                String pm25= doc.select(pm25CssQuery).text().trim();
                if(!area.equals("")){
                    //handle pm2.5 value when pm2.5 is ND and empty
                    pm25Map.put(area,pm25.equals("ND")||pm25.equals("")?-1:Integer.parseInt(pm25));
                }
            }
            
        }catch(IOException e){
             e.printStackTrace();
        }
     }
    public static void main(String [] args) throws IOException{
        System.out.println(pm25Map);
    }
}

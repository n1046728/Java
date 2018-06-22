import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Date;
import javax.swing.JOptionPane;

//reference https://stackoverflow.com/questions/7080205/popup-message-boxes
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException{
        Document doc = Jsoup.connect("http://......").get();
            //System.out.println(doc.select("h2 a"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Elements titles = doc.getElementsByTag("h2");
        Boolean tag=true;
        while(true){
            
            for(Element item: titles){
                if(item.text().contains("text")){
                    System.out.println(item.text());
                    infoBox("text "+dateFormat.format(new Date()),"notice" );
                    System.out.println(dateFormat.format(new Date()));
                    tag=false;
                }
            }
            System.out.println("------------------------"+dateFormat.format(new Date()));
            if(tag=true){
                Thread.sleep(60000);
            }else{
                System.out.println("program is terminated"); 
                break;
            }
        }
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}

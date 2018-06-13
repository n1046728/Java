import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class JsonTest {
	public static void main(String args [] ) throws Exception{
		/* Note 20180601
		 * 		Introducing JSON: www.json.org
		 * 		select java->google-gson
		 * 		
		 * 		傳輸F.F(flate file)純文字->xml->json		
		 * 
		 * 		add gson.jar
		 * 			right-clicking on the Project → Build Path → Configure Build Path. Under Libraries tab, 
		 * 			click Add Jars or Add External JARs and give the Jar.
		 *	
		 *		天氣數據openweathermap.org
		 *			search taipei  
		 *			API->JSON->otherfeathers
		 *		
		 *		install chrome jsonView
		 *
		 *		google 行政院農委會JSON->食安飲食->check json ->市售米不合格->資料介接	
		 * 		gooele UBike json->使用資料->資料存取網址->更改副檔名.json
		 * 		google 行政院農委會JSON->農業旅遊->check json ->伴手禮->資料介接
		 * 
		 * 		自己補充：	
		 * 			GoogleGsonTutorial: https://howtodoinjava.com/apache-commons/google-gson-tutorial-convert-java-object-to-from-json/
		 * 			github: https://github.com/google/gson
		 */			
		URL url= new URL("http://data.coa.gov.tw/Service/OpenData/FromM/AgricultureiRiceFailure.aspx");
		InputStreamReader reader = new InputStreamReader(url.openStream());
		System.out.println(reader.ready());
		Gson gson = new Gson();
		BadFood [] badFoods =new Gson().fromJson(reader, BadFood[].class);
		
		System.out.println(badFoods.length);
		for(BadFood badFood:badFoods){
			if(badFood.品名.contains("米")){
				System.out.printf("%s\t%s\t%s\n",badFood.品名,badFood.國際條碼,badFood.不合格原因);
			}
		}
	}
	public class BadFood{
		public String Title;
		public String 編號;
		public String 品名;
		public String 不合格原因;
		public String 國際條碼;
		
	}
}


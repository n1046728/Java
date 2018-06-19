import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class JsonTest {
	public static void main(String args [] ) throws Exception{
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


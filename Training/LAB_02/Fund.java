import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Fund {
	public static void main(String []args) throws FileNotFoundException, UnsupportedEncodingException{
		File f = new File("src\\fund.csv");
		
		//it is not working when workspace set encoding UTF-8 
		//so we use scanner and set encoding is BIG5 that file is encoded by big5
		
		//Scanner scanner = new Scanner(f);
		Scanner scanner = new Scanner(f,"BIG5");
		
		System.out.println(scanner.hasNext());
		scanner.next();
		
		double avg =0; 
		while(scanner.hasNext()){
			String data = scanner.next();
			String rows[] = data.split(",");
			String funds[]= new String[rows.length-1]; 
			
			double sum = 0;
			for(int i=1;i<rows.length;i++){
				sum +=Double.parseDouble(rows[i]);
				funds[i-1] =rows[i];
			}
			avg=sum/(rows.length-1);
			
			double sum2=0;
			for(String s:funds){
				
				sum2 += Math.pow(Double.valueOf(s)-avg, 2);
			}
			//calculate standard deviation
			Double sd = Math.sqrt(sum2/funds.length); 
			//calculate coefficient of variation
			Double cv = sd/avg;
			
			System.out.println(String.format("sum:%.2f avg:%.2f sd:%.2f cv:%.2f", sum,avg,sd,cv));
		}
	}
}


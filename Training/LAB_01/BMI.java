
public class BMI {
	public static void main(String[] args){
		//{{height...},{weight...}}
		double [][] source=new double[][]{{175.5,168,178.5,181},{73.2,60.3,78.8,88.6}};
		
		//calculate BMI 
		//BMI formula kg/m^2
		double h=0;
		double w=0;
		for(int i=0;i<source[0].length;i++){
			h=source[0][i]/100;
			w=source[1][i];
			System.out.println(String.format("height:%.2f , weight:%.2f , BMI:%.2f",
								h,w,w/Math.pow(h, 2)));
		}
	}
}

public class Test3 {

	public static void main(String[] args) {
		//JAVA_8 old
		Calc add = new Calc(){
			@Override
			public double result(double x, double y) {
				return x+y;
			}
		};
		System.out.println(add.result(2, 3));
		//lambda 
		Calc add2 = (double x,double y)-> x+y;
		System.out.println(add2.result(2,3));
		
		//參數型態已定義在interface中，故可不寫
		Calc multi = (x,y)->x*y;
		System.out.println(multi.result(2,3));
		
		//多行
		Calc bmi = ((w,h)->{
			double value = w/Math.pow(h/100, 2);
			return value;
		});
		System.out.printf("%.2f",bmi.result(60, 170));
		
		//求max，min
		//Calc max
		//Calc min
		
		Calc max = ((x,y)->{
			if (x>y){
				return x;
			}else{
				return y;
			}
		});
		
		Calc min = (x,y) -> x>y?y:x;
		System.out.println(max.result(2, 3));
		System.out.println(min.result(2, 3));
		
	}
}

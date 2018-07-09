public class Test2 {
	public static void main(String [] args){
		//匿名內部類別
		Calc add = new Calc(){

			@Override
			public double result(double x, double y) {
				return x+y;
			}
		};
		Calc bmi = new Calc(){

			@Override
			public double result(double w, double h) {
				return w/Math.pow(h/100, 2);
			}
		};
		
		System.out.println(add.result(2, 3));
		System.out.printf("%.2f",bmi.result(60,170 ));
	}
}

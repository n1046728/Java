public class Test {

	public static void main(String[] args) {
		Calc calc = new CalcAdd();
		System.out.println(calc.result(2, 3));
		Calc calc2 =new CalcBMI();
		System.out.printf("%.2f",calc2.result(60, 170));
	}
}

//介面實作
public class CalcBMI implements Calc {

	@Override
	public double result(double w, double h) {
		return w/Math.pow(h/100, 2);
	}
}

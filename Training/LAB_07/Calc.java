//SAM (Single Abstract Method),只有一個抽樣方法，這樣lambda才能使用
//介面預設都是abstract加不加都可以
//介面預設都是public加不加都可以

public interface Calc {
	double result(double x , double y );
	
	//interface 實作，大家要用一樣的
	default void copyright(){
		System.out.println("xxx Co., Ltd.");
	}
}

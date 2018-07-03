import java.util.Date;

public class Transaction {
    private static Transaction instance =new Transaction();
    //private constructor
    private Transaction(){
        System.out.println("create Transaction object");
    }
    //public method to get transaction
    public static final Transaction getTransaction(){
        return instance;
    }
    
    public void submit(int money){
        System.out.println("交易金額："+money);
    }
    
    //====================
    // poolsize的做法
    //====================
    //目的：分散物件的loading
    
    private static int poolSize=10;
    private static Transaction[] instanceArr=new Transaction[poolSize];
    static{
        for(int i =0;i<poolSize;i++){
            instanceArr[i] = new Transaction();
        } 
    }
    
    public static final Transaction getTransactionFromPool(){
        int index = (int)(new Date().getTime()%poolSize);
        return instanceArr[index];
    }
}

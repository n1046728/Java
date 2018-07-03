public class SingletonTest {
    public static void main(String [] args){
//        Transaction t1 = new Transaction();
//        t1.submit(1_0000);
        
        Transaction t2 = Transaction.getTransaction();
        t2.submit(2_0000);
        
        Transaction t3 = Transaction.getTransactionFromPool();
        t3.submit(3_0000);
    }
}

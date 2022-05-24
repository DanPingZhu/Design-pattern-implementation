package singleton;

/**
 * @author ZDP
 * @data 2022/5/4 11:05 下午
 */
public class LazzyMan {
    private static LazzyMan INSTANCE;

    private LazzyMan(){}

    //加锁 synchronized
    public static synchronized LazzyMan getInstance(){
        if(INSTANCE == null){
            // 延时1ms
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new LazzyMan();
        }
        return INSTANCE;
    }
    public void method(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(LazzyMan.getInstance().hashCode());
            }).start();
        }
    }

}

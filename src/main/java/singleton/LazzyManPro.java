package singleton;

/**
 * @author ZDP
 * @data 2022/5/24 3:44 下午
 */

//双重锁校验
public class LazzyManPro {
    private static LazzyManPro INSTANCE;

    private LazzyManPro(){}

    public static  LazzyManPro getInstance(){
        if(INSTANCE == null){
            synchronized (LazzyManPro.class){
                if(INSTANCE == null){
                    // 延时1ms
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new LazzyManPro();
                }
            }

        }
        return INSTANCE;
    }
    public void method(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(LazzyManPro.getInstance().hashCode());
            }).start();
        }
    }
}

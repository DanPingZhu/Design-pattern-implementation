package singleton;

/**
 * @author ZDP
 * @data 2022/5/24 4:10 下午
 */
public enum EnumSingle {
    //枚举单例
    INSTANCE;

    public void m(){}


    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(EnumSingle.INSTANCE.hashCode());
            }).start();
        }
    }

}

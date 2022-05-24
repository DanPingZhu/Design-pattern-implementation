package singleton;

/**
 * @author ZDP
 * @data 2022/5/24 3:57 下午
 */

// 静态内部类
public class StaticClassMan {
    private StaticClassMan(){

    };

    private static class StaticClassManHolder{
        private static final StaticClassMan INSTANCE = new StaticClassMan();
    }

    public static StaticClassMan getInstance(){
        return StaticClassManHolder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(StaticClassMan.getInstance().hashCode());
            }).start();
        }
    }
}

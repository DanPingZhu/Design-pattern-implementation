package singleton;

//饿汉模式
//类加载到内存之后，就实例化一个单例，JVM保证线程安全


/**
 * @author ZDP
 * @data 2022/5/4 11:05 下午
 */

public class HungryMan {
    private static final HungryMan INSTANCE = new HungryMan();

    private HungryMan() {};

    private static HungryMan getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("singleton HungryMAn");
    }

    public static void main(String[] args){
        HungryMan m1 = HungryMan.getInstance();
        HungryMan m2 = HungryMan.getInstance();
        System.out.println(m1 == m2);
    }
}
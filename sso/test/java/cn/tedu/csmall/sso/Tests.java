package cn.tedu.csmall.sso;


import org.junit.jupiter.api.Test;

public class Tests {
    @Test
    public void test01(){
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        LazySingleton s3 = LazySingleton.getInstance();
        LazySingleton s4 = LazySingleton.getInstance();
        System.out.println(s3);
        System.out.println(s4);

        Aoo bean = Factory.getBean("d");
        System.out.println(bean);
    }
}
/**
 * 单例模式：饿汉式（急加载）单例模式
 */
class Singleton{

    private static final Singleton instance = new Singleton();

    // 私有化构造，不让外界随机new对象
    private Singleton(){};

    public static Singleton getInstance(){
        return instance;
    }
}
/**
 * 单例模式：懒汉式单例模式
 */
class LazySingleton{

    private static LazySingleton instance = null;

    private LazySingleton(){}

//    public static LazySingleton getInstance(){
//        if(instance == null){
//            synchronized(LazySingleton.class){
//                if(instance == null){
//                    instance = new LazySingleton();
//                }
//            }
//        }
//        return instance;
//    }

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}

class Aoo{

}
class Boo extends Aoo{

}
class Coo extends Aoo{

}
class Factory{
    public static Aoo getBean(String name){
        if("a".equals(name)){
            return new Aoo();
        }else if("b".equals(name)){
            return new Boo();
        }else if("c".equals(name)){
            return new Coo();
        }else{
            return null;
        }
    }
}

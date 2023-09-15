package cn.tedu;

public class TestVariable {
    public static void main(String[] args) {
        f(1,"a",1,3,true,new String("1111"),'a');
    }
    //可变长参数 本质上是数组
    //一个方法中,只允许有一个可变参数,并且还必须要放在最后
    public static void f(int b,Object... a) {
        for (Object o : a) {
            System.out.println(o);
        }
    }
}

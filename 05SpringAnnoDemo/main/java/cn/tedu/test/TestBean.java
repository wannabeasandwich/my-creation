package cn.tedu.test;


import cn.tedu.service.impl.UserServiceImpl;

public class TestBean {
    private static UserServiceImpl service;

    public static void main(String[] args) {
        service = new UserServiceImpl();
        service.save();
    }
}

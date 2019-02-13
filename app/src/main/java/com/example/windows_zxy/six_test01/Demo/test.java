package com.example.windows_zxy.six_test01.Demo;

public class test {
    /**
     * 1608C
     * 移动通信
     * 张新滟
     */
    public static void main(String[] args) {
        //获取字节码
        Class<UtilTest> c1 = UtilTest.class;
        //三种方式
        UtilTest utilTest = new UtilTest();
        //1
        Class aClass = utilTest.getClass();
        //2
        try {
            Class c3 = Class.forName("com.example.windows_zxy.six_test01.Demo.test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

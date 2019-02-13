package com.example.windows_zxy.six_test01.Demo;

public class UtilTest {
    private String name;
    int age;

    public UtilTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UtilTest() {

    }
    private void fun(String name,int age){
        this.age=age;
        this.name=name;
        System.out.println("name="+name+"----age="+age);
    }
    public void fun(){
        System.out.println("name="+name+"----age="+age);
    }
}

package com.example.homework1.myutil;

public class CountBean {
    private static int num=0;
    private int curNum=0;
    public int getCurNum(){
        curNum=num;
        return curNum;
    }
    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        CountBean.num = num;
    }
}

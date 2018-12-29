package com.example.demo.utils;

public class Model {

    private int num = 0;
    private int numAll = 0;

    synchronized public void setNum(int num) {
        this.num = num;
    }

    synchronized  public int getNum() {
        return num;
    }

    synchronized public int getNumAll() {
        return numAll;
    }

    synchronized public void setNumAll(int numAll) {
        this.numAll = numAll;
    }
}

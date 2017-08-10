package com.brainacad.gui;

/**
 * Created by Павло on 10.08.2017.
 */
public final class MyClass {

    private String a;
    protected int b;
    public double c;
    boolean d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public boolean isD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public MyClass() {
    }

    public MyClass(String a) {
        this.a = a;
    }

    public MyClass(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public MyClass(String a, int b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public MyClass(String a, int b, double c, boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}

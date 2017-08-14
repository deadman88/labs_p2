package TestReflection1;

/**
 * Created by stas on 11.08.2017.
 */
public class MyClass {
    int a;
    private int b;
    public int c;
    protected int d;

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public MyClass() {

    }

    public MyClass(int b, int c) {
        this.b = b;
        this.c = c;
    }

    public MyClass(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}

package example;

import java.util.Arrays;
import java.util.Date;

public class HelloBean {
    private String str;
    private byte[] bytes;
    private Date date;

    private int anInt;
    private TestBean testBean;

    public HelloBean(int anInt) {
        System.out.println("HelloBean anInt constructor called");
        this.anInt = anInt;
    }

    public HelloBean() {
        System.out.println("HelloBean default constructor called");
    }

    public String getStr() {
        System.out.println("HelloBean getStr called");
        return str;
    }

    public void setStr(String str) {
        System.out.println("HelloBean setStr called");
        this.str = str;
    }

    public byte[] getBytes() {
        System.out.println("HelloBean getBytes called");
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        System.out.println("HelloBean setBytes called");
        this.bytes = bytes;
    }

    public Date getDate() {
        System.out.println("HelloBean getDate called");
        return date;
    }

    public void setDate(Date date) {
        System.out.println("HelloBean setBytes called");
        this.date = date;
    }

    public int getAnInt() {
        System.out.println("HelloBean getAnInt called");
        return anInt;
    }

    public void setAnInt(int anInt) {
        System.out.println("HelloBean setAnInt called");
        this.anInt = anInt;
    }

    public TestBean getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }

    @Override
    public String toString() {
        return "HelloBean{" +
                "str='" + str + '\'' +
                ", bytes=" + Arrays.toString(bytes) +
                ", date=" + date +
                ", anInt=" + anInt +
                ", testBean=" + testBean +
                '}';
    }
}

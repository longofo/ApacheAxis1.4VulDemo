package example;

public class TestBean {
    private String aaa;
    private int bbb;

    public TestBean(String aaa) {
        System.out.println("TestBean constructor aaa called");
        this.aaa = aaa;
    }

    public TestBean(byte[] bytes) {
        System.out.println("TestBean constructor bytes called");
    }

    public TestBean(int bbb) {
        System.out.println("TestBean constructor bbb called");
        this.bbb = bbb;
    }

    public TestBean(String aaa, byte[] bytes) {
        System.out.println("TestBean constructor aaa bytes called");
        this.aaa = aaa;
    }

    public TestBean(String aaa, int bbb) {
        System.out.println("TestBean constructor aaa bbb called");
        this.aaa = aaa;
        this.bbb = bbb;
    }

//    public TestBean() {
//        System.out.println("TestBean default constructor called");
//    }

    public String getAaa() {
        System.out.println("TestBean getAaa called");
        return aaa;
    }

    public void setAaa(String aaa) {
        System.out.println("TestBean setAaa called");
        this.aaa = aaa;
    }

    public int getBbb() {
        System.out.println("TestBean getBbb called");
        return bbb;
    }

    public void setBbb(int bbb) {
        System.out.println("TestBean setBbb called");
        this.bbb = bbb;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "aaa='" + aaa + '\'' +
                ", bbb='" + bbb + '\'' +
                '}';
    }
}

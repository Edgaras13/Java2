package Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Address address = new Address(Country.LITHUANIA, "Vilnius", "Antakalnio", "116");

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule sm = new SimpleModule("AddressDeserializer");
        sm.addDeserializer(Address.class, new AddressDeserializer(Address.class));
        mapper.registerModule(sm);

        File file = new File("D:\\Projects\\Java2\\day182\\src\\main\\java\\Test\\file2.json");
        mapper.writeValue(file,address);

        Address address1 = mapper.readValue(file, Address.class);
        System.out.println(address1);
    }
}

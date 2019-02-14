package Exercise3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{
        List<Company> list = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 100; i++){
            list.add(new Company(faker.company().name(),
                    i,
                    random.nextInt(3001),
                    new BigDecimal(random.nextDouble() * 10000).setScale(2, RoundingMode.DOWN).doubleValue()));
        }

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("D:\\Projects\\Java2\\day182\\src\\main\\java\\Exercise3\\company_list.json");
        mapper.writeValue(file, list);
    }
}

package FizzBuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static String fizzBuzz(Integer i){
        List<String> list = new ArrayList<>();
        for (int j = 1; j <= i; j++ ){
            list.add(String.valueOf(j));
        }
        return list.stream()
                .map(k -> (Integer.parseInt(k) % 3 == 0 && Integer.parseInt(k) % 5 == 0)?
                        k = "FizzBuzz" : (Integer.parseInt(k) % 3 == 0)?
                        k = "Fizz": (Integer.parseInt(k) % 5 == 0)?
                        k = "Buzz": k)
                .collect(Collectors.joining(","));

    }
}

package NumberSequence;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }
    public static String seperate(List<Integer> list){
        return list.stream()
                .map(i -> (i % 2 == 0)? i + "e": i + "o")
                .collect(Collectors.joining(","));
    }
}

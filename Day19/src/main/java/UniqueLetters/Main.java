package UniqueLetters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    public static List<Character> uniqueLetters(List<String> list){
        return list.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .map(word -> word.charAt(0))
                .collect(Collectors.toList());
    }
}

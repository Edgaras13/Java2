package Grouping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    public static void grouping(List<Character> list){
        Map<Character, Long> map = list.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        try {
            File file = new File("D:\\Projects\\Java2\\Day19\\src\\main\\java\\Grouping\\result.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Character c : map.keySet()) {
                writer.write(c + " " + map.get(c) + "\n");
            }
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

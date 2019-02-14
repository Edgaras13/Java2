import NumberSequence.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTests {
    @Test
    void testNumberSequence(){
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        System.out.println(Main.seperate(list));
        assertEquals("0e,1o,2e,3o,4e,5o,6e,7o,8e,9o",Main.seperate(list));
    }

    @Test
    void testBetterWord(){
        String word1 = "Hello";
        String word2 = "Guys";
        BiPredicate<String, String> biPredicate = (x, y) -> x.length() > y.length();
        System.out.println(BetterWord.Main.betterWord(word2, word1, biPredicate));
        assertEquals(true, BetterWord.Main.betterWord(word1, word2, biPredicate));
    }

    @Test
    void testUniqueLetters(){
        List<String> list = Arrays.asList("Hello", "Guys", "123-", "Hey");
        List<Character> list2 = UniqueLetters.Main.uniqueLetters(list);
        System.out.println(list2);
        assertEquals(Arrays.asList('H', 'e', 'l', 'o', 'G', 'u', 'y', 's', '1', '2', '3', '-'),UniqueLetters.Main.uniqueLetters(list));
    }

    @Test
    void testGrouping(){
        List<Character> list = Arrays.asList('a','a','a','b','b','c','v','v','v','v');
        Grouping.Main.grouping(list);
    }

    @Test
    void testFizzBuzz(){
        assertEquals("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz,Fizz,22,23,Fizz,Buzz,26,Fizz,28,29,FizzBuzz", FizzBuzz.Main.fizzBuzz(30));
    }
}

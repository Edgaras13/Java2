package BetterWord;

import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean betterWord(String word1, String word2, BiPredicate<String,String > biPredicate){
        return biPredicate.test(word1, word2);
    }
}

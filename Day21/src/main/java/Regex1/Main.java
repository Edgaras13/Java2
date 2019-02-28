package Regex1;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna al" +
                "iqua. Ut enim ad minim veniam, quis nostrud exercitation ullam" +
                "co laboris nisi ut aliquip ex ea commodo consequat. Duis aute " +
                "irure dolor in reprehenderit in voluptate velit esse cillum do" +
                "lore eu fugiat nulla pariatur. Excepteur sint occaecat cupidat" +
                "at non proident, sunt in culpa qui officia deserunt mollit ani" +
                "m id est laborum.";

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(text.replaceAll("(\\s|^|,|\\.)[lL]\\S*(\\s|\\.|\\,)","$1******$2"));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(text.replaceAll("\\s", "\n"));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(text.replaceAll("([,.]\\s)","$1\n"));
        System.out.println("----------------------------------------------------------------------------------");
    }
}

package ExampleRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1 {
    public static void main(String[] args) {
        //1st way
        Pattern p = Pattern.compile(".s");//.represent single character
        Matcher m = p.matcher("as");
        boolean b = m.matches();

        //2nd way
        boolean b2 = Pattern.compile(".s").matcher("as").matches();

        //3nd way
        boolean b3 = Pattern.matches(".s","as");

        //example
        boolean b4 = Pattern.matches(".m..","amal");

        //print
        System.out.println(b+" "+b2+" "+b3+" "+b4);
        //mencocokan karakter yang sesuai
        //tanda titik mewakili sisa dari total karakter depan atau belakang
        //karakter dapat diletakkan di posisi mana saja

        System.out.println(Pattern.matches(".s","as"));//true
        System.out.println(Pattern.matches(".s","mk"));//false
        System.out.println(Pattern.matches(".s","mst"));//false
        System.out.println(Pattern.matches(".s","amms"));//false
        System.out.println(Pattern.matches("..s","mas"));//true

        System.out.println(Pattern.matches("[amn]","abcd"));//false (not a or m or n)
        System.out.println(Pattern.matches("[amn]","a"));//true (among a or m or n)
        System.out.println(Pattern.matches("[amn]","ammmna"));//false (m and a comes more than once)

        //regex password
        System.out.println("----Password----");
        String passwd = "aaZZa44@";
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        System.out.println(passwd.matches(pattern));
        System.out.println(Pattern.matches(pattern,passwd));

        //? Quantifier
        System.out.println("? Quantifier ....");
        //membaca satu karakter yang di input
        System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)
        System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a m and n comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "m"));//false (a or m or n must come one time)

        System.out.println("+ quantifier ....");
        //yaitu membaca karakternya ada atau tidak
        System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)
        System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)
        System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)
        System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)

        System.out.println("* quantifier ....");
        System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)

    }
}

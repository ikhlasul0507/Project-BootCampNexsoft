package ExampleRegex;

import java.util.regex.Pattern;

public class RegexMetaCharacterExample {
    public static void main(String[] args) {
        System.out.println("Meta Character d ....");
        //true = jika regex huruf kecil == angka (digit sama)
        System.out.println(Pattern.matches("\\d","a"));//false (non digit)
        System.out.println(Pattern.matches("\\d","1"));//true (digit and come once)
        System.out.println(Pattern.matches("\\d","4443"));//false (digit and comes more than)
        System.out.println(Pattern.matches("\\d","323abc"));//false (digit and character)

        System.out.println("Meta Character D .....");
        //true = jika regex huruf besar == huruf (digit sama)
        System.out.println(Pattern.matches("\\D","abc"));//false (non digit but comes more than once)
        System.out.println(Pattern.matches("\\d","1"));//false (digit)
        System.out.println(Pattern.matches("\\D","1"));//false (digit)
        System.out.println(Pattern.matches("\\D","4443"));//false (digit)
        System.out.println(Pattern.matches("\\D","323abc"));//false (digit and char)
        System.out.println(Pattern.matches("\\D","M"));//true (non digit and comes once)

        System.out.println("Meta Character D with Quantifier ....");
        System.out.println(Pattern.matches("\\D+","mak"));//true (non digit and may come 0 or more times)

        //stringhadphone
        String[] tesStrings = {
                //valid phone number
                "(123)4567898","1234567890","123-456-7890","(123)456-7898",
                //invalid phone number
                "(122234567890)","123)4567898","12345678901","(1)234567890",
                "(123)-4567898","1","12-3456-7898","123-4567","Hello World"
        };
        //patern handphone
        // \\d{10} = total 10 tanpa pemisah
        // \\(?:\\d{3}-){2}\\d{4} = jumlah karakter dipisah dengan tanda (-)
        // ?:\\d{3}-){2} = yaitu 3 karater sebanya 2 dipisah dengan -.
        // \\(\\d{3}\\)\\d{3}-?\\d{4} = (3 karater)3karater-4 karakter
        //tanda \\ pemisah dari regex

        String patern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        System.out.println(Pattern.matches(patern,"123456789"));

        for(String inputString : tesStrings){
            System.out.print(inputString + ": ");
            if(inputString.matches(patern)){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }
        }
    }
}

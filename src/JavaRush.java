import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class JavaRush {

    /**
     * ЧТО ПРОЙДЕНО
     * Считывание с клавиатуры
     * Массивы (многомерные массивы ||  deepToString) класс Arrays
     * Литералы (int x = 3_000_000 || long x = 3_000_000L)
     * двоичная (0b1111), восьмиричная(017), шестнацатиричная(0xF) системы счисления (здесь везде число 15)
     * класс Math
     * switch-case таким образом (или добавить break или yield)
     *      [] int x = 0;
     *      [] String text = switch (x) {
     *      []     case 1 -> "ONE";
     *      []     case 2 -> "TWO";
     *      []     default -> "THREE";
     *      [] };
     * логические операции (отличие && от & || от |)
     * Экранирование символов, char
     * String (работа со строками) - неизменяемый тип, создает новую ячейку памяти при изменении старой строки
     * StringBuilder - изменяемый тип, не создает новых ячеек памяти при изменении старой строки
     */

    public static void main(String[] args) {

        String good1 = "good. day! yad doog.";
        String good2 = "A man, a plan, a canal: Panama";
        String bad1 = "abb";
        String bad2 = "race a car";

        System.out.println(canWeMakePalindrome(good1));
        System.out.println(canWeMakePalindrome(good2));
        System.out.println(canWeMakePalindrome(bad1));
        System.out.println(canWeMakePalindrome(bad2));

    }

    public static boolean canWeMakePalindrome(String text) {
        text = numsAndLetters(text);
        if (text.length() == 1) return true;
        if (text.length() == 2 && text.charAt(0) != text.charAt(1)) return false;
        char[] textArray = text.toCharArray();
        int[] lettersCount = new int[textArray.length];
        Arrays.sort(textArray);
        int count = 1;
        int index = 0;
        for (int i = 0; i < textArray.length - 1; i++) {
            if (i == textArray.length - 2) {
                lettersCount[index] = count + 1;
            }
            if (textArray[i] != textArray[i + 1]) {
                lettersCount[index] = count;
                index = i + 1;
                count = 1;
            } else count ++;
        }
        System.out.println(Arrays.toString(textArray));
        System.out.println(Arrays.toString(lettersCount));
        boolean isOdd = false;
        for (int i : lettersCount) {
            if (i % 2 != 0 && !isOdd) {
                isOdd = true;
                continue;
            }
            if (i % 2 != 0 && isOdd) return false;
        }
        return true;
    }

    public static String numsAndLetters(String s) {
        String result = "";
        s = s.toLowerCase();
        HashSet<Character> set = setter();
        for (int i = 0; i < s.length(); i++)
            if (set.contains(s.charAt(i))) result = result + s.charAt(i);
        return result;
    }

    public static HashSet<Character> setter() {
        HashSet<Character> result = new HashSet<Character>();
        result.add('q'); result.add('w'); result.add('e'); result.add('r');
        result.add('t'); result.add('y'); result.add('u'); result.add('i');
        result.add('o'); result.add('p'); result.add('a'); result.add('s');
        result.add('d'); result.add('f'); result.add('g'); result.add('h');
        result.add('j'); result.add('k'); result.add('l'); result.add('z');
        result.add('x'); result.add('c'); result.add('v'); result.add('b');
        result.add('n'); result.add('m');
        result.add('0'); result.add('1'); result.add('2'); result.add('3');
        result.add('4'); result.add('5'); result.add('6'); result.add('7');
        result.add('8'); result.add('9');
        return result;
    }

}



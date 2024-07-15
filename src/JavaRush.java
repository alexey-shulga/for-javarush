import java.lang.reflect.Array;
import java.util.Arrays;
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
        String bad1 = "123456";

        System.out.println(canWeMakePalindrome(good1));
        System.out.println(canWeMakePalindrome(bad1));

    }

    public static boolean canWeMakePalindrome(String text) {
        text = text.toUpperCase().trim();
        text = text.replaceAll(" ", "");
        text = text.replaceAll(",", "");
        text = text.replaceAll("\\.", "");
        text = text.replaceAll("!", "");
        text = text.replaceAll("\\?", "");
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
        boolean isOdd = false;
        for (int i : lettersCount) {
            if (i % 2 != 0 || isOdd) return false;
        }
        System.out.println(Arrays.toString(textArray));
        System.out.println(Arrays.toString(lettersCount));
        return true;
    }





}



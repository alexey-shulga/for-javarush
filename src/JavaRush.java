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

        int[] nums = new int[]{0, 1, 0, 3, 12, 0, 0, 0, 100};

        System.out.println("BEFORE:");
        System.out.println(Arrays.toString(nums));
        System.out.println("AFTER:");
        nums = exeZeros(nums);
        System.out.println(Arrays.toString(nums));



        Persona[] memory = new Persona[]{
                new Persona("Alex", 27, true),
                null,
                new Persona("Diana", 27, false),
                new Persona("Yarik", 7, true),
                null,
                new Persona("Vasya", 55, true),
                null,
                null,
                null,
                new Persona("Galya", 49, false)
        };

    }

    public static int[] exeZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }



}



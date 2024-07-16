import java.lang.reflect.Array;
import java.util.*;

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
     * StringBuffered - как и StringBuilder только потокобезопасный
     */

    public static void main(String[] args) throws Throwable{

        for (int i = 0; i < 100000; i++) {
            System.out.print(i + " >>> ");
            Persona pers1 = new Persona("Alex", 27, true);
            System.out.println(pers1);
            pers1 = null;
            Persona pers2 = new Persona();
            pers2.setName("XYU");
            pers2.setAge(22);
            pers2.setGender(false);
        }

    }

}



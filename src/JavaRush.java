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

        Programmer pr1 = new Programmer(
                "Alexey Shulga",
                27,
                true,
                "Google",
                10,
                new String[] {"Java", "Git", "Docker", "Maven/Gradle"}
        );
        Programmer pr2 = new Programmer();
        pr2.setName("Shulga Alexey");
        pr2.setAge(27);
        pr2.setGender(true);
        pr2.setCompanyName("Google");
        pr2.setJobExperience(10);
        pr2.setJobStack(new String[] {"Java", "Git", "Docker", "Maven/Gradle"});


        System.out.println(pr1.hashCode() + " " + pr2.hashCode());
        System.out.println("By hash: " + (pr1.hashCode() == pr2.hashCode()));
        System.out.println("By equals: " + pr1.equals(pr2));

    }

    public static Persona[] makeRandomPersona(int persCount, int maxAge) {
        Persona[] result = new Persona[persCount];
        for (int i = 0; i < persCount; i++) {
            result[i] = new Persona();
            result[i].setName(getRandText());
            result[i].setAge((int)(Math.random() * maxAge));
            result[i].setGender(i % 2 == 0 ? true : false);
        }
        return result;
    }

    public static String getRandText() {
        String result = "";
        char[] letters = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
        };
        for (int i = 0; i < (int) (Math.random() * 10); i++) {
            int random = (int) (Math.random() * 36);
            result += letters[random];
        }
        return result;
    }

}



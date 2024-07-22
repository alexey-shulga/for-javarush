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
     * Типы-обертки Integer, Character, Double, Boolean, Float, Long (в этих типах есть свои методы !!!)
     * Основа Коллекций ArrayList, LinkedList (хз как с ним работать и нах он нужен)
     * Iterator<> для обхода коллекции и удаления/изменения элементов во время обхода
     * При переводе из ArrayList в обычный массив (arraylist.toArray(new Array[0])) лучше указать пустой массив
     *      в качестве параметра, т.к. это улучшит производительность, хз почему так
     * Дженерики - типы данных в которых есть возможность установить типы в качестве параметра,
     *      например Collection<Integer> или ТипДанных<ТипПараметра>
     * Автоупаковка/автораспаковка (для приведения Integer в int можно ничего не делать, компилятор сам разберется с этим)
     *      (ИСКЛЮЧЕНИЕ - массив int[] и массив Integer[] - разные)
     *
     *
     *
     */

    public static void main(String[] args) throws Throwable{

        HashMap<String, Integer> mapa = new HashMap<>(){{
            put("ALEXEY SHULGA", 180);
            put("DINA SHULGA", 170);
            put("YAROSLAVV SHULGA", 120);
        }};

        System.out.println(mapa.get("ALEXEY SHULGA"));

        mapa.forEach((key, val) -> System.out.printf("NAME: %s | HEIGH: %d\n", key, val));

    }



    public static Persona[] makeRandomPersona(int persCount, int maxAge) {
        Persona[] result = new Persona[persCount];
        for (int i = 0; i < persCount; i++) {
            result[i] = new Persona();
            result[i].setName(getRandText());
            result[i].setAge((int)(Math.random() * maxAge) + 1);
            result[i].setGender(i % 2 == 0 ? Gender.MALE : Gender.FEMALE);
        }
        return result;
    }

    public static String getRandText() {
        String result = "";
        char[] letters = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
        };
        for (int i = 0; i < (int) (Math.random() * 10) + 1; i++) {
            int random = (int) (Math.random() * 36);
            result += letters[random];
        }
        return result;
    }

}



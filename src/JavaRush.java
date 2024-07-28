import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.DoubleToIntFunction;

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
     * Автоупаковка/автораспаковка (boxing/unboxing) (для приведения Integer в int можно ничего не делать,
     *      компилятор сам разберется с этим) (ИСКЛЮЧЕНИЕ - массив int[] и массив Integer[] - разные)
     * Исключение. Throwable - базовый класс для всех исключений.
     *      От Throwable идеи два вида Error и Exception.
     *      Error - серьезные ошибки, типа нехватка памяти, ошибки в работе программы, переполнение стека и пр.
     *      Exception - обычные ошибки, которые могут быть вызваны работой методов
     *      (деление на 0, переменная равна null, в метод переданы неверные аргументы и пр.)
     *      Исключения могут быть проверяемы и непроверяемые (checked / unchecked).
     *      Все RuntimeException и Error являются непроверяемыми, остальные проверяемые
     *      Если метод будет выбрасывать проверяемое исключение, то в сигнатуре метода указывается это, напр.:
     *          public void calc(int num) throws Exception {
     *              if (num == 0)
     *                  throw new Exception("NUM равно 0");
     *          }
     *          ЕСЛИ УДАЛИТЬ THROWS EXCEPTION то это исключение будет непроверяемое!
     * Стэк Трейс StackTrace - позволяет увидеть какой класс и метод выполняется в программе
     *      напр.: StackTraceElement[] methods = Thread.currentThread().getStackTrace();
     * try-catch-finally
     * try-with-resources в данную конструкцию можно передать только классы унаследованные от AutoClosable =(
     * InputStream - входящий поток | OutputStream - исходящий поток | Оба потока считывают/записывают данные в виде байтов
     *      это два класса для чтения/записи
     * Reader / Writer - два класса для чтения/записи, но делают не байтами а символами
     * Все открытые потоки должны быть закрыты ПОТОК.close()
     * Класс Path используется для работы с файловой системой (технически это интерфейс)
     *      для каждой операционной системы создается объект для работы именно с этой операционкой
     *      (WindowsPath, UnixPath и пр.)
     *      при создании нет ключчевого слова -new- Path filePath = Path.of(PATH_TO_FILE);
     *      метода Path https://javarush.com/quests/lectures/questsyntaxpro.level15.lecture04
     * Класс Files используется для работы с файлами, он работает с объектами класса Path
     *      методы Files https://javarush.com/quests/lectures/questsyntaxpro.level15.lecture05
     * Класс URL для работы с ресурсами в интернете
     *
     *
     */

    public static void main(String[] args) throws IOException {

        final String inputPath = "C:\\Users\\Shulga\\Desktop\\base.txt";
        final String outputPath = "C:\\Users\\Shulga\\Desktop\\base2.txt";

        Path path = Path.of("C:/Users/Shulga/Desktop/Deleted/path1/file1.txt");
        List<String> fileText = Files.readAllLines(path);
        ArrayList<Integer> ints = new ArrayList<>();
        fileText.forEach(x -> {
            ints.add(Integer.parseInt(x));
        });
        Collections.sort(ints, Collections.reverseOrder());
        Iterator iter = ints.iterator();
        while (iter.hasNext()) {
            Integer item = (Integer) iter.next();
            if (item % 2 == 0)
                iter.remove();
        }
        ints.forEach(x -> System.out.println(x));

    }



    public static Persona[] makeRandomPersona(int persCount, int maxAge) {
        Persona[] result = new Persona[persCount];
        for (int i = 0; i < persCount; i++) {
            result[i] = new Persona();
            result[i].setName(getRandText(10));
            result[i].setAge((int)(Math.random() * maxAge) + 1);
            result[i].setGender(i % 2 == 0 ? Gender.MALE : Gender.FEMALE);
        }
        return result;
    }

    public static String getRandText(int len) {
        String result = "";
        char[] letters = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
        };
        for (int i = 0; i < (int) (Math.random() * len) + 1; i++) {
            int random = (int) (Math.random() * 36);
            result += letters[random];
        }
        return result;
    }

    // Довольно быстрое копирование из файла в файл
    // если делать копирование через readAllBytes файл читался/писался ~10 секунд
    // если делать через read(byte[]) файл читается/пишется ~0.5 секунд
    /*try (FileInputStream input = new FileInputStream(inputPath);
        FileOutputStream output = new FileOutputStream(outputPath)) {
        byte[] buf = new byte[60000];
        while (input.available() > 0) {
            int i = input.read(buf);
            output.write(buf, 0, i);
        }
    }*/

}



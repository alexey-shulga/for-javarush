import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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
     *      Files появился в Java 7, до этого работой с файлами занимался класс File
     *      Подробнее про Files и еще про обход дерева директорий https://javarush.com/groups/posts/2275
     *      методы Files https://javarush.com/quests/lectures/questsyntaxpro.level15.lecture05
     * Класс URL для работы с ресурсами в интернете
     * Класс URLConnection для работы с подключениями через сеть, возможно отправлять данные по URL или получать данные
     *      URLConnection connect = url.openConnection();
     *      connect.getInputStream() - получение объекта InputStream для получения инфы
     *      connect.getOutputStream() - получение объекта OutputStream для передачи инфы
     * Date - класс для работы с датами и временем
     *      дни недели нумеруются с ВОСКРЕСЕНЬЯ с 0
     *      (можно получать дату / время например getYear() и изменять их например setYear())
     * SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-YYYY") - формат для отображения даты
     *      String result = formatter.format(Date) - получили дату в формате, который мы указали
     *      Date.parse() - с помощью этого метода можно пропарсить строку
     *      Например { Date date = new Date(); date.setTime(Date.parse(Jul 06 12:00:00 2019)); }
     * Calendar - класс для работы с датами, но более продвинутый, чем date
     *      Calendar date = Calendar.getInstance() - создание даты с текущим календарем
     *      дни недели нумеруются с ВОСКРЕСЕНЬЯ с единицы
     *      есть 3 типа календарей (GregorianCalendar BuddhistCalendar JapaneseImperialCalendar)
     *      add() - метод позволяет добавить/уменшить количество дней/месяцев и тд в дате
     *      roll() - прокручивает определенный параметр (день, месяц, год и тд) в дате, не трогая остальные параметры
     * Date Time API - совеременное средство для работы с датами
     *      java.time - базовый пакет для Date Time API
     *      LocalDate LocalTime LocalDateTime Instant Period Duration - обекты этих классов иммутабельны
     *      после создания они не изменяются
     *      java.time.format - пакет содержит в себе классы для форматирования времени
     *          DateTimeFormatter (пришел на замену SimpleDateFormatter)
     *      java.time.zone - пакет содержит классы для работы с часовыми зонами
     *          (TimeZone, ZonedDateTime)
     *      шаблоны в DateTimeFormatter https://javarush.com/quests/lectures/questsyntaxpro.level16.lecture07
     * В интерфейсах в методах с реализацией нужно писать ключевое слово default
     * В абстрактных классах в методах без реализации нужно писать ключевое слово abstract
     *
     *
     *
     * Тут про STREAM API, прикольная тема - https://annimon.com/article/2778
     */

    public static void main(String[] args) throws  IOException{
        long timeStart = System.currentTimeMillis();

        Moderator moder1 = new Moderator();
        moder1.setUserName("MODERATOR 1");
        moder1.setUserId(112L);
        moder1.setAccess("MODER");

        System.out.println(moder1);

        System.out.printf("==========\nВремя работы программы составило: %d мс", System.currentTimeMillis() - timeStart);
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



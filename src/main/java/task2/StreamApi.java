package task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {

        /*
        Найдите в списке целых чисел 3-е наибольшее число (пример: 5 2 10 9 4 3 10 1 13 => 10)
        */
        var list1 = Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13);
        System.out.println(list1.stream().sorted(Comparator.reverseOrder()).toList().get(2));

        /*
        Найдите в списке целых чисел 3-е наибольшее «уникальное» число (пример: 5 2 10 9 4 3 10 1 13 => 9,
        в отличие от прошлой задачи здесь разные 10 считает за одно число)
        */
        System.out.println(list1.stream().distinct().sorted(Comparator.reverseOrder()).toList().get(2));

        /*
        Найдите в списке слов самое длинное
        */
        var listWords = Arrays.asList("Слово", "я", "параллелограмм", "ОНО", "Словa");
        System.out.println(listWords.stream()
                .sorted(Comparator.comparing(String::length))
                .toList()
                .getLast());

        /*
        Отпечатайте в консоль строки из списка в порядке увеличения длины слова,
        если слова имеют одинаковую длины, то должен быть сохранен алфавитный порядок
        */
        printSortedWordByLing(listWords);
    }

    /*
    Имеется список объектов типа Сотрудник (имя, возраст, должность),необходимо получить список имен 3
    самых старших сотрудников с должностью «Инженер», в порядке убывания возраста
    */
    List<String> getNameThreeOldEngineerReverseAge(List<Worker> workers) {
        return workers.stream()
                .filter(worker -> worker.getPosition().equals("Engineer"))
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(3)
                .map(Worker::getName)
                .toList();
    }

    /*
    Имеется список объектов типа Сотрудник (имя, возраст, должность),
    посчитайте средний возраст сотрудников с должностью «Инженер»
    */
    Double getAvgAgeEngineerInCompany(List<Worker> workers) {
        return workers.stream()
                .filter(worker -> worker.getPosition().equals("Engineer"))
                .collect(Collectors.averagingDouble(Worker::getAge));
    }

    /*
    Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапы,
    в которой будут хранится пары: слово - сколько раз оно встречается во входной строке
    */
    Map<String, Long> getMapSizeWordFromString(String s) {
        return Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    static void printSortedWordByLing(List<String> stringList) {
        stringList.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .toList()
                .forEach(System.out::println);
    }

    /*
    Имеется массив строк, в каждой из которых лежит набор из 5 слов, разделенных пробелом,
    найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них
    */

    String getWordMaxLength(String[] strings) {
        return Arrays.stream(strings)
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .sorted(Comparator.comparing(String::length))
                .toList()
                .getLast();
    }

    interface Worker {
        String getName();

        Integer getAge();

        String getPosition();
    }
}

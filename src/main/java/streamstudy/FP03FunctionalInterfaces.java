package streamstudy;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {


    public static void main(String[] args) {
        List<String> courses = of("Spring", "Spring Boot", "API", "Micorservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> courses2 = of("Spring", "Spring Boot", "API", "Micorservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        /*System.out.println(courses.stream().flatMap(course -> courses2.stream()
                .filter(course2 -> course2.length() == course.length())
                .map(course2 -> of(course, course2)))
                .collect(Collectors.toList()));*/


        /*System.out.println(numbers.stream().map(str -> str.split(""))
                .flatMap(Arrays::stream).collect(Collectors.toList()));*/


    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }

    private static void isEvenPrint(List<Integer> numbers, Predicate<? super Integer> isEvenPredicate) {
        numbers.stream()
                .filter(isEvenPredicate)
                .forEach(System.out::println);
    }

    private static List<String> of(String ...values) {
        return Arrays.stream(values).collect(Collectors.toList());
    }
}

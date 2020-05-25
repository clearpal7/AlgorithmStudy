package codility;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Task2 {
    public static void main(String[] args) {
        Map<String, UserStats> map1 = new HashMap<>();
        map1.put("1", new UserStats());
        Map<String, UserStats> map2 = new HashMap<>();
        map2.put("2", new UserStats());

        Map<Long, Long> map = count(map1, map2);
        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static Map<Long, Long> count(Map<String, UserStats>... visits) {
       Map<String, UserStats> visitMap =  Arrays.stream(visits).flatMap(m -> m.entrySet().stream())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


       return visitMap.entrySet().stream()
               .filter(entry -> entry != null)
               .filter(isVisitCount())
               .filter(isNumeric())
               .collect(Collectors.toMap(entry -> Long.parseLong(entry.getKey()), entry -> entry.getValue().visitCount.get()));

    }

    public static Predicate<Map.Entry<String, UserStats>> isVisitCount() {
        return (entry -> {
            if(entry.getValue().visitCount.isPresent())
                return true;
            return false;
        });
    }

    private static Predicate<Map.Entry<String, UserStats>> isNumeric() {
        return (entry -> {
           return true;
        });
    }
}

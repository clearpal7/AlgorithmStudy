package streamstudy;

import hackerrank.domain.Node;

import java.util.*;

public class FP02Structured {

    public static void main(String[] args) {
        /*int[] nums = new int[] {12, 9, 13, 4, 6, 2, 4, 12, 15};
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(nums).boxed().forEach(num -> numbers.add(num));

        int sum = addListStructured(numbers);
        int max = getMaxValueWithFunctional(numbers);
        int squareSum = getSquareSum(numbers);*/
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                NodePoint nodePoint1 = (NodePoint)o1;
                NodePoint nodePoint2 = (NodePoint)o2;
                return nodePoint1.getDistinctOrigin() < nodePoint2.getDistinctOrigin() ? -1 : 1;
            }
        };
        List<NodePoint> nodePoints = new ArrayList<>();
        nodePoints.add(new NodePoint(1,2));
        nodePoints.add(new NodePoint(1,3));
        nodePoints.add(new NodePoint(1,1));
        Collections.sort(nodePoints,Comparator.reverseOrder());
        nodePoints.stream().forEach(n -> System.out.println(((NodePoint) n).y));
    }

    private static void sorted(List<Integer> numbers) {
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    private static void sortedLength(List<String> strings) {
        strings.stream().distinct().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }

    private static void printDistinctNumbers(List<Integer> numbers) {
        numbers.stream().distinct().forEach(System.out::println);
    }

    private static int getSquareSum(List<Integer> numbers) {
        return numbers.stream().map(x -> x*x).reduce(Integer::sum).get();
    }

    private static int getOddSum(List<Integer> numbers) {
        return numbers.stream().filter(x -> x%2==1).reduce(Integer::sum).get();
    }

    private static int getMaxValueWithFunctional(List<Integer> numbers) {
        return numbers.stream().reduce(FP02Structured::max).get();
    }

    private static int sum(int a, int b) {
        System.out.println(a + " " + b);
        return a + b;
    }

    private static int max(int a, int b) {
        return a < b ? a : b;
    }

    private static int addListStructured(List<Integer> numbers) {
        return numbers.stream().reduce(0, FP02Structured::sum);
    }
}
class NodePoint implements Comparable{
    int x;
    int y;
    public NodePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Object other) {
        NodePoint point = (NodePoint)other;
        int first = (x*x) + (y*y);
        int second = ((point.x) * (point.x)) + ((point.y) * (point.y));
        return first < second ? -1 : 1;
    }

    public int getDistinctOrigin() {
        return (x*x) + (y*y);
    }
}
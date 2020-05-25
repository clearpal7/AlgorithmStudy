import java.util.HashSet;
import java.util.Set;

public class Branches {

    public static int count(int[] tree) {
        Set<Integer> set = new HashSet<>();
        for(int node : tree) {
            if(node != -1) {
                set.add(node);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
    }
}

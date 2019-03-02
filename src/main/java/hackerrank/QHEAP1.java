package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QHEAP1 {

    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(bufferedReader.readLine());

      PriorityQueue<Integer> queue = new PriorityQueue<>(new IntegerComparator());


      for(int i = 0; i < N; i++) {
          String[] s = bufferedReader.readLine().split(" ");
          int type = Integer.parseInt(s[0]);
          if(type == 1) {
            queue.add(Integer.parseInt(s[1]));
          } else if(type == 2) {
            queue.remove(Integer.parseInt(s[1]));
          } else if(type == 3) {
              int temp = queue.peek();
              System.out.println(temp);
          }
      }
    }
}
class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}
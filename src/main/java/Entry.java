import java.util.LinkedList;
import java.util.Queue;

public class Entry {

        Queue<String> passportQueue = new LinkedList<>();
        public void enter(String passportNumber) {
            passportQueue.offer(passportNumber);
        }

        public String leave() {
           return passportQueue.poll();
        }

        public static void main(String[] args) {
            Entry entry = new Entry();
            entry.enter("AB54321");
            entry.enter("UK32032");
            System.out.println(entry.leave());
            System.out.println(entry.leave());
            System.out.println(entry.leave());
        }
}

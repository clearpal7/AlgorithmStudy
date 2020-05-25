package kakao;


import java.util.*;

public class LocalWebHosting {

    public static void main(String[] args) {
        List<Integer> timeStamp = new ArrayList<>();
        List<Integer> top = new ArrayList<>();
        timeStamp.add(0);
        timeStamp.add(1);
        timeStamp.add(1);
        timeStamp.add(2);
        timeStamp.add(4);
        timeStamp.add(5);




        top.add(5);

        System.out.println(requestsServed(timeStamp, top));
    }

    static final int bufferMaxSize = 5;
    public static int requestsServed(List<Integer> timeStamp, List<Integer> top) {

        Collections.sort(timeStamp);

        LinkedList<Integer> requests = new LinkedList<>(timeStamp);
        Queue<Integer> buffer = new LinkedList<>();
        List<Integer> tempStore = new ArrayList<>();

        int count = 0;

        for(Integer limit : top) {
            if(buffer.size() == bufferMaxSize) {
                for(Integer temp : tempStore) {
                    requests.add(0, temp);
                }
                tempStore.clear();
                count += buffer.size();
                buffer = new LinkedList<>();
            }

            while (requests.size() != 0){
                Integer current = requests.getFirst();
                if(current <= limit) {
                    requests.removeFirst();
                    buffer.add(current);
                } else {
                    break;
                }
                if(buffer.size() > 5) {
                    tempStore.add(buffer.poll());
                }
            }
        }

        if(buffer.size() > 0)
            count += buffer.size();

        return count;
    }

    private static void clearList(Queue<Integer> buffer, List<Integer> tempStore) {
        buffer.clear();
        tempStore.clear();
    }

}

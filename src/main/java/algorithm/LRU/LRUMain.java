package algorithm.LRU;

public class LRUMain {

    public static void main(String[] args) {
        int time = 0;
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        LRU lru = new LRU(cacheSize);
        System.out.print(lru.getCalculateCitiesTime(cities));
    }
}

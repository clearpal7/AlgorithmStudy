package leetcode.contest182;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    private Map<String, Map<Integer, Integer>> checkInMap;
    private Map<String, Map<Integer, Integer>> checkOutMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.putIfAbsent(stationName, new HashMap<>()).put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        checkOutMap.putIfAbsent(stationName, new HashMap<>()).put(id, t);
    }

    public double getAverageTime(String startStation, String endStation) {
        double avg = 0.0;
        int count = 0;
        Map<Integer, Integer> startMap = checkInMap.get(startStation);
        Map<Integer, Integer> destMap = checkOutMap.get(endStation);

        for(Map.Entry entry : startMap.entrySet()) {
            Integer startKey = (Integer) entry.getKey();
            if(destMap.containsKey(startKey)) {
                avg += destMap.get(startKey) - startMap.get(startKey);
                count++;
            }
        }
        if(count != 0)
            avg = avg / count;
        return avg;
    }
}
class Main {
    public static void main(String[] args) {

    }
}

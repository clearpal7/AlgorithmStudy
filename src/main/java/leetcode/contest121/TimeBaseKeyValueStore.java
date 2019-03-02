package leetcode.contest121;

import java.util.*;

public class TimeBaseKeyValueStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }
}

class TimeMap {

    Map<String, List<ValueAndTime>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(this.map.containsKey(key)) {
            List<ValueAndTime> list = this.map.get(key);
            list.add(new ValueAndTime(value, timestamp));
            this.map.put(key, list);
        } else {
            List<ValueAndTime> list = new ArrayList<>();
            list.add(new ValueAndTime(value, timestamp));
            this.map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if(this.map.containsKey(key)) {
            List<ValueAndTime> list = this.map.get(key);
            String largestValue = "";
            int prevTimeStamp = 0;
            int prevIndex = -1;
            for(int i = 0 ; i < list.size(); i++) {
                if(list.get(i).timeStamp <= timestamp) {
                   prevTimeStamp = Math.max(list.get(i).timeStamp, prevTimeStamp);
                   if(prevTimeStamp == list.get(i).timeStamp) {
                       prevIndex = i;
                   }
                }
            }
            if(prevIndex != -1) {
                return list.get(prevIndex).value;
            } else {
             return "";
            }
        } else {
            return "";
        }
    }
}

class ValueAndTime {
    String value;
    int timeStamp;

    public ValueAndTime(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }
}

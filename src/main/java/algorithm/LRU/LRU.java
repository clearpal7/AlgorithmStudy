package algorithm.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends LinkedHashMap {

    int initSize = 0;

    public Map<String, String> lru;
    public String firstKey;

    private LRU() {}

    public LRU(int init) {
        this.initSize = init;
        if(lru == null) {
            lru = new LinkedHashMap<String, String>(this.initSize, 0.85f, true);
        }
    }

    public void put(String k) {
        String key = k.toLowerCase();
        String value = k.toLowerCase();
        if(!isExceed()) {
            if(firstKey == null) {
                firstKey = key;
            }
            lru.put(key, value);
        } else {
            remove(firstKey);
            lru.put(key, value);
            if(lru.size() > 0) {
                String fKey = lru.entrySet().stream().findFirst().get().getKey();
                firstKey = fKey;
            }
        }
    }

    public String remove(String key) {
         return lru.remove(key.toLowerCase());
    }

    public boolean containsKey(String key) {
        return lru.containsKey(key.toLowerCase());
    }


    public boolean isExceed() {
        if(this.initSize <= lru.size()) {
            return true;
        }
        return false;
    }

    public int getCalculateCitiesTime(String[] cities) {
        int times = 0;
       if(cities.length > 0) {
           if(this.lru.size() <= 0) {
               return 5 * cities.length;
           }
           for(String city : cities) {
               if(containsKey(city)) {
                    ++times;
               } else {
                   times += 5;
                   put(city);
               }
           }
       }
       return times;
    }


}

package datastructure;


import java.util.*;

public class MultiTreeSet<E> {
    int size;
    private TreeMap<E, Integer> freqTreeMap;

    public MultiTreeSet() {
        this.size = 0;
        this.freqTreeMap = new TreeMap<>();
    }

    public void add(E element, int count) {
        Integer freq = freqTreeMap.get(element);
        if(freq == null) {
            freqTreeMap.put(element, count);
        } else {
            freqTreeMap.put(element, freqTreeMap.get(element) + count);
        }
        ++size;
    }

    public void addAll(Collection<? extends E> collection) {
        for(E element : collection) {
            add(element, 1);
        }
    }

    public Integer get(E element) {
        Integer freq = freqTreeMap.get(element);
        if(freq == null) {
            return 0;
        } else {
            return freq;
        }
    }

    public void delete(E element) {
        Integer freq = freqTreeMap.get(element);
        if(freq == null)
            return;
        if(freq == 1) {
            freqTreeMap.remove(element);
        } else {
            freqTreeMap.put(element, freqTreeMap.get(element) - 1);
        }
        --size;
    }

    public Set<E> keySet() {
        return freqTreeMap.keySet();
    }

    public boolean containsKey(E element) {
        if(freqTreeMap.containsKey(element)) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        int count = 0;
        for(E element : freqTreeMap.keySet()) {
            count += freqTreeMap.get(element);
        }
        return count;
    }

}

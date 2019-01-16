package algorithm;

import java.util.ArrayList;

public class PartialSet {

    public ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = set.size();
        for(int k = 0; k < max; k++) {
            ArrayList<Integer> subset = getConvertToInt(k, set);
            allsubsets.add(subset);
        }

    }

    public ArrayList<Integer> getConvertToInt(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for(int k = x; k > 0 ;k>>=1) {
            if((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}

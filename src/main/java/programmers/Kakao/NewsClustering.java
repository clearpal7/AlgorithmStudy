package programmers.Kakao;

import datastructure.MultiTreeSet;

import java.util.*;

public class NewsClustering {

    public static void main(String[] args) {
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        List<String> splitStr1 = splitString(str1);
        List<String> splitStr2 = splitString(str2);

        Set<String> allStrs = new HashSet<>();
        allStrs.addAll(splitStr1);
        allStrs.addAll(splitStr2);

        MultiTreeSet<String> A = new MultiTreeSet<>();
        MultiTreeSet<String> B = new MultiTreeSet<>();
        A.addAll(splitStr1);
        B.addAll(splitStr2);

        MultiTreeSet<String> intersection = new MultiTreeSet<>();
        MultiTreeSet<String> union = new MultiTreeSet<>();

        //교집합
        for(String key : A.keySet()) {
            if(B.containsKey(key)) {
                intersection.add(key, Math.min(A.get(key), B.get(key)));
                B.delete(key);
            }
        }

        //합집합
        for(String s : allStrs) {
            if(A.containsKey(s) && B.containsKey(s)) {
                union.add(s, Math.max(A.get(s), B.get(s)));

            } else if(A.containsKey(s)) {
                union.add(s, A.get(s));
            } else {
                union.add(s, B.get(s));
            }
        }
        double answer = 0;

        if(intersection.size() == 0)
            return 65536;


            answer = ((double)intersection.size() / (double)union.size());


        return (int) ((double)intersection.size() / (double)union.size() * (double) 65536);
    }

    public static List<String> splitString(String str) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++) {
            String temp = str.substring(i, i+2).toLowerCase();
            if(temp.matches("^[a-z]+$"))
                list.add(temp);
        }
        return list;
    }
}

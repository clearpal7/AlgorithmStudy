package programmers;


import java.util.*;
import java.util.stream.Collectors;


/*
public class FindingPrime {

    public List<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;
        boolean[] isPrime = getErastoPrime(9999999);

        List<Character> characters = numbers.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        //List<Integer> integers = characters.stream().map(Integer::new).collect(Collectors.toList());

        for(int i = 0; i < characters.size(); i++) {

            make(characters.get(i), i);

        }

        return answer;
    }

    private static void make(Character character, int index) {
        isVisited.put(index, true);


    }

    private static boolean[] getErastoPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for(int i = 2; i * i <=n; i++) {
            for(int j = i * i; j <=n; j+=i) {
                if(isPrime[j] == true) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
*/

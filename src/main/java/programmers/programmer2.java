package programmers;


import java.util.Arrays;

public class programmer2 {

    public static void main(String[] args) {
        int[] people = {1,2,3};
        int[] tshirts = {1,1};

        System.out.print(solution(people, tshirts));
    }

    public static int solution(int[] people, int[] tshirts) {
        int answers = 0;

        Arrays.sort(people);
        Arrays.sort(tshirts);

        boolean[] isAlreadyWeared = new boolean[people.length];

        for(int tshirtsIndex = 0; tshirtsIndex < tshirts.length; tshirtsIndex++) {
            for(int peopleIndex = 0 ; peopleIndex < people.length; peopleIndex++) {
                if (tshirts[tshirtsIndex] >= people[peopleIndex] && isAlreadyWeared[peopleIndex] == false) {
                    ++answers;
                    isAlreadyWeared[peopleIndex] = true;
                    break;
                }
            }
        }



        return answers;
    }
}

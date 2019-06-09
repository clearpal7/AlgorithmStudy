package leetcode.contest138;

public class GrumpyBookstoreOwner_1052 {

    public static void main(String[] args) {
        int[] customers = {2,6,6,9};
        int[] grumpy = {0,0,1,1};
        int X = 1;
        System.out.println(maxSatisfied(customers, grumpy, X));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int firstIndex = 0;
        int max = 0;

        for(int i = 0; i <= customers.length - X; i++) {
            int sum = 0;
            int secondIndex = firstIndex + 1;
            int thridIndex = firstIndex + 2;
            for(int j = 0; j < customers.length; j++) {
               if(j == firstIndex || j == secondIndex || j == thridIndex) {
                    sum += customers[j];
               } else {
                   if(grumpy[j] != 1)
                       sum += customers[j];
               }

            }
            ++firstIndex;
            max = Math.max(sum, max);
        }
        return max;
    }

}

package leetcode.contest162;

import java.util.ArrayList;
import java.util.List;

public class ReconstructA2_RowBinaryMatrix_1253 {

    public static void main(String[] args) {
        int upper = 3;
        int lower = 2;
        int[] colsum = {2,1,1,0,1};

        List<List<Integer>> result = reconstructMatrix(upper, lower, colsum);

        for(List<Integer> row : result) {
            for(int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i) + " | ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int sum0 = 0;
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < n; i++) {
            if(colsum[i] == 2) sum2++;
            else if(colsum[i] == 1)sum1++;
            else if(colsum[i] == 0) sum0++;
        }

        int count1 = upper - sum2;
        int count2 = lower - sum2;

        if(count1 < 0 || count2 < 0 || count1 + count2 != sum1) return new ArrayList<>();

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            answer.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            //2인 경우
            if(colsum[i] == 2) {
                answer.get(0).add(1);
                answer.get(1).add(1);
            } else if(colsum[i] == 0) {
                answer.get(0).add(0);
                answer.get(1).add(0);
            } else {
                if(count2 > 0) {
                    count2--;
                    answer.get(0).add(0);
                    answer.get(1).add(1);
                } else {
                    answer.get(0).add(1);
                    answer.get(1).add(0);
                }
            }
        }

        return answer;
    }
}


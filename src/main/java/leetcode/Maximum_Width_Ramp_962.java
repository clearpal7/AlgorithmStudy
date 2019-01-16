package leetcode;



public class Maximum_Width_Ramp_962 {

    public static void main(String[] args) {
        int[] A = {6,0,8,2,1,5};
        System.out.println(maxWidthRamp(A));
    }

    //접근법을 단순히 엔제곱으로 가져갓음 처음에는, 그러나 마지막부터 비교하면 그 뒤부터 비교할필요가없으므로 break로 시간단축한
    public static int maxWidthRamp(int[] A) {

        int max = 0;

        for(int i = A.length - 1; i > 0; i--) {
            for(int j = 0 ; j < i; j++) {
                if(A[j] <= A[i]) {
                    max = Math.max(max, i - j);
                    break;
                }
            }
        }
        return max;
    }

  /* public public static int maxWidthRamp(int[] A) {
        int max = 0;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for(int i = 0 ; i < A.length; i++) {
            integerMap.put(A[i], i);
        }

        Arrays.sort(A);
        int from = A.length - 1;
        for(int i = 0 ; i < A.length ; i++) {
            for(int j = from ; j > i ; j--) {
                if(integerMap.get(j) > integerMap.get(i)) {
                    max = Math.max(max, j - i);
                }
            }
            from--;
        }
        return max;
    }*/
}

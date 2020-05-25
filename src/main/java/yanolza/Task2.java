package yanolza;

public class Task2 {

    public static void main(String[] args) {
        int[] A = {-3, -3};
        System.out.print(solution(A));
    }

    public static int solution(int[] A) {
        int N =A.length;
        int count = 0;
        for(int center = 0; center < N; center++) {
            int leftMove = center - 1;
            int rightMove = center + 1;

            while(leftMove >= 0 && rightMove < N && !isHill(center, leftMove, rightMove, A)
                    && !isValley(center, leftMove, rightMove, A) && !isLeftStair(center, leftMove, rightMove, A)
                    && !isRightStair(center, leftMove, rightMove, A)) {

                --leftMove;
                ++rightMove;
            }

            if(isHill(center, leftMove, rightMove, A)) {
                ++count;
                center = rightMove + 1;
            } else if(isValley(center, leftMove, rightMove, A)) {
                ++count;
                center = rightMove + 1;
            }

        }
        return count;
    }

    private static boolean isHill(int center, int leftMove, int rightMove, int[] A) {
        boolean check = false;
        if(leftMove < 0 || A[center] < A[leftMove])
            check = true;
        if(rightMove >= A.length || A[center] < A[rightMove])
            check = true;

        return check;
    }

    private static boolean isValley(int center, int leftMove, int rightMove, int[] A) {
        boolean check = false;

        if(leftMove < 0 || A[center] > A[leftMove])
            check = true;
        if(rightMove >= A.length || A[center] > A[rightMove])
            check = true;

        return check;
    }

    private static boolean isLeftStair(int center, int leftMove, int rightMove, int[] A) {
        boolean check = false;
        if(leftMove < 0 || A[center] > A[leftMove])
            check = true;
        if(rightMove >= A.length || A[center] < A[rightMove])
            check = true;
        return check;
    }

    private static boolean isRightStair(int center, int leftMove, int rightMove, int[] A) {
        boolean check = false;
        if(leftMove < 0 || A[center] < A[leftMove])
            check = true;
        if(rightMove >= A.length || A[center] > A[rightMove])
            check = true;
        return check;
    }

}

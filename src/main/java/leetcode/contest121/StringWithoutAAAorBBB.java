package leetcode.contest121;

public class StringWithoutAAAorBBB {

    public static void main(String[] args) {
        int A = 1;
        int B = 3;
        System.out.print(strWithout3a3b(A, B));
    }

    public static String strWithout3a3b(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        int L = stringBuilder.length();

        while (A > 0 || B > 0) {
            if(L >=2  && stringBuilder.charAt(L - 1) == stringBuilder.charAt(L - 2)) {
                if(A > 0 && stringBuilder.charAt(L - 1) == 'b') {
                    stringBuilder.append('a');
                    A = A - 1;
                } else if(B > 0 && stringBuilder.charAt(L - 1) == 'a'){
                    stringBuilder.append('b');
                    B = B - 1;
                }
            } else {
                if(A == B && A > 0 && B > 0) {
                    stringBuilder.append("ab");
                    A = A - 1;
                    B = B - 1;
                } else if(A > B) {
                    stringBuilder.append('a');
                    A = A - 1;
                } else if(B > 0){
                    stringBuilder.append('b');
                    B = B - 1;
                }

            }
            L = stringBuilder.length();
        }

        return stringBuilder.toString();
    }
}

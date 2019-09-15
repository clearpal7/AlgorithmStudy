package leetcode.contest144;



public class CorporateFlightBookings_1109 {

    public static void main(String[] args) {
        int[][] bookings = {
                {1,2,10},
                {2,3,20},
                {3,5,25}
        };

        int n = 5;
        int[] answer = corpFlightBookings(bookings, n);

        for(int a : answer) {
            System.out.println(a);
        }

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
       int[] res = new int[n];
       for(int[] booking : bookings) {
           res[booking[0] - 1] += booking[2];
           if(booking[1] < n)
               res[booking[1]] -= booking[2];
       }
       for(int i = 1; i < n; i++) {
           res[i] += res[i-1];
       }
       return res;
    }


}

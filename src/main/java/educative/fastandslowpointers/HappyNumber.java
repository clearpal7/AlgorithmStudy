package educative.fastandslowpointers;

public class HappyNumber {

    public static boolean find(int num) {
        int slow = num;
        int fast = num;

        while(fast != 1) {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
            if(slow == fast)
                return false;
        }


        return fast == 1 ? true : false;
    }

    private static int calculate(int num) {
        int sum = 0;
        while(num > 0) {
            int residual = num % 10;
            sum += residual * residual;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}

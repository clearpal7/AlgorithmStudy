package educative.xor;

public class CalculateComplement {


    public static int bitwiseComplement(int num) {
        int bitCount = 0;
        int n = num;

        while(n > 0) {
            ++bitCount;
            n = n >> 1;
        }

        int allBitSet = (int) Math.pow(2, bitCount) - 1;

        return num ^ allBitSet;
    }

    public static void main(String[] args) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}

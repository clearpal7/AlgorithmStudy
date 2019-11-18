package leetcode.contest144;

public class DefangingAnIPAddress_1108 {

    public static void main(String[] args) {
        String ip = "1.1.1.1";
        System.out.println((defangIPaddr(ip)));
    }

    public static String defangIPaddr(String address) {
        String[] addr = address.split("\\.");
        String sub = "[.]";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < addr.length; i++) {
            stringBuilder.append(addr[i]);

            if (i != addr.length - 1) {
                stringBuilder.append(sub);
            }
        }

        return stringBuilder.toString();
    }
}

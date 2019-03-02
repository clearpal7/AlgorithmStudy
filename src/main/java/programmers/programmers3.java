package programmers;

import java.util.*;

public class programmers3 {

    public static void main(String[] args) {
        int[] healths = {200, 120, 150};
        int[][] items = {
                {30, 100}, {500, 30}, {100, 400}
        };

        int[] result = solution(healths, items);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(int[] healths, int[][] items) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(healths);

        List<Weapon> weaponList = new ArrayList<>();
        for(int i = 0; i <items.length; i++) {
            Weapon weapon = new Weapon(items[i][0], items[i][1]);
            weaponList.add(weapon);
        }

        boolean[] isAlreadyWeapon = new boolean[weaponList.size()];

        for(int i = 0; i < healths.length; i++) {
            for(int j = 0; j < weaponList.size(); j++) {
                Weapon weapon = weaponList.get(j);
                if(healths[i] - weapon.minusHealth >= 100 && isAlreadyWeapon[j] == false) {
                    result.add(j + 1);
                    isAlreadyWeapon[j] = true;
                    break;
                }
            }
        }
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}

class Weapon implements Comparator {
    int plusAttack;
    int minusHealth;

    public Weapon(int plusAttack, int minusHealth) {
        this.plusAttack = plusAttack;
        this.minusHealth = minusHealth;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Weapon weapon1 = (Weapon) o1;
        Weapon weapon2 = (Weapon) o2;
        return Integer.compare(weapon1.minusHealth, weapon2.minusHealth);
    }
}
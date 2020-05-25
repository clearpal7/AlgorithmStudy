package codility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Task3 {

    public static void main(String[] args) {
        String riddle = "????????";
        System.out.println(solution(riddle));
    }

    public static String solution(String riddle) {

        Map<Integer, Character> characterMap = initMap();

        StringBuilder stringBuilder = new StringBuilder();
        char[] riddleChars = riddle.toCharArray();

        for(int currentPoint = 0; currentPoint < riddleChars.length; currentPoint++) {
            if(riddleChars[currentPoint] == '?') {
                if(currentPoint == riddleChars.length - 1 || currentPoint == 0) {
                    convertCharFirstAndLast(characterMap, riddleChars, currentPoint);

                } else {
                    int leftPoint = currentPoint;
                    int rightPoint = currentPoint;
                    while (leftPoint > 0 && riddleChars[leftPoint] == '?') {
                        --leftPoint;
                    }
                    while (rightPoint < riddleChars.length - 1 && riddleChars[rightPoint] == '?') {
                        ++rightPoint;
                    }
                    char leftChar = riddleChars[leftPoint];
                    char rightChar = riddleChars[rightPoint];

                    converCharacter(characterMap, riddleChars, leftPoint, rightPoint);
                }
            }
        }

        return Stream.of(riddleChars).collect(Collector.of(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString));
    }

    private static void convertCharFirstAndLast(Map<Integer, Character> characterMap, char[] riddleChars, int currentPoint) {
        for(Map.Entry entry : characterMap.entrySet()) {
            Character character = (Character) entry.getValue();
            if(currentPoint - 1 > 0 && character != riddleChars[currentPoint - 1]) {
                riddleChars[currentPoint] = character;
            } else if(currentPoint + 1 < riddleChars.length - 1 && character != riddleChars[currentPoint + 1]) {
                riddleChars[currentPoint] = character;
            }
        }
    }

    private static void converCharacter(Map<Integer, Character> characterMap, char[] riddleChars, int leftPoint, int rightPoint) {
        for (int i = leftPoint + 1; i < rightPoint; i++) {
            char leftChar = riddleChars[i - 1];
            char rightChar = riddleChars[i + 1];
            for (Map.Entry entry : characterMap.entrySet()) {
                Character character = (Character) entry.getValue();
                if (i == rightPoint - 1) {
                    if (character != leftChar && character != rightChar) {
                        riddleChars[i] = character;
                        break;
                    }
                } else if (character != leftChar) {
                    riddleChars[i] = character;
                }
            }

        }
    }

    private  static Map<Integer, Character> initMap() {
        Map<Integer, Character> characterMap = new LinkedHashMap<>();
        for(int i = 0; i < 26; i++) {
            characterMap.put(i, (char) (i + 'a'));
        }
        return characterMap;
    }
}

package leetcode.contest154;

/*public class MaximumNumberOfBalloons_1189 {

    public int maxNumberOfBalloons(String text) {
        char[] characters = text.toCharArray();
        int count = 0;
        Map<String, Integer> initMap = init();
        Map<Character, Integer> textMap = new LinkedHashMap<>();

        for(char c : characters) {
            if(c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                textMap.computeIfPresent(c, (key , value) -> value + 1);
            }
        }

        for(Character key : textMap.keySet()) {

        }
    }

    private static Map<String, Integer> init(Map<Character, Integer> textMap) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("l", 2);
        map.put("o", 2);
        map.put("b", 1);
        map.put("n", 1);

        textMap.put('b', 0);
        textMap.put('a')
        return map;
    }

}*/

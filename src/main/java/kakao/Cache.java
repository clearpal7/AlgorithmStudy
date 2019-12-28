package kakao;

public class Cache {

    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Pangyo", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(3, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LRU<String, String> clsTemp = LRU.newInstance(cacheSize);
        for (int i = 0; i < cities.length; i++) {
            String sTemp = cities[i].toUpperCase();
            if(clsTemp.containsKey(sTemp)) {
                answer++;
            }else {
                answer +=5;
            }
            clsTemp.put(sTemp, sTemp);
        }

        return answer;
    }
}

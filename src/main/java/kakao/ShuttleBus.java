package kakao;

import java.util.ArrayList;
import java.util.List;

public class ShuttleBus {

    public String solution(int n, int t, int m, String[] timetable) {

        List<Integer> timeMinutes = new ArrayList<>(timetable.length);
        for(int i = 0; i < timetable.length; i++) {
            int hours = Integer.parseInt(timetable[i].substring(0,2));
            int minutes = Integer.parseInt(timetable[i].substring(3,5));
            timeMinutes.add(hours * 60 + minutes);
        }
        
        String answer = "";
        return answer;
    }
}

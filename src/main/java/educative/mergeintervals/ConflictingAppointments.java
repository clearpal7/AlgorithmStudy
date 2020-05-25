package educative.mergeintervals;

import java.util.*;

public class ConflictingAppointments {

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        List<Interval> list = Arrays.asList(intervals);
        list.stream().sorted((a,b) -> a.start - b.start);

        boolean isResult = true;
        for(int i = 1; i < list.size(); i++) {
            Interval A = list.get(i-1);
            Interval B = list.get(i);
            if(isOverlap(A, B)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlap(Interval a, Interval b) {
        if(a.start <= b.start && a.end >= b.end) {
            return true;
        } else if(a.start <= b.start && a.end >= b.start) {
            return true;
        }
        return false;
    }
}

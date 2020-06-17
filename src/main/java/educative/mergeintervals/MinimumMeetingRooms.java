package educative.mergeintervals;

import java.util.*;

public class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if(meetings.size() <= 0)
            return -1;

        int count = 0;
        int max = Integer.MIN_VALUE;
        int index = 0;

        int start = meetings.get(index).start;
        int end = meetings.get(index).end;
        int previousEnd = 0;

        Collections.sort(meetings, (a,b) -> a.start - b.start);

        index++;
        while(index < meetings.size()) {
            Meeting meeting = meetings.get(index++);

            int nextStart = meeting.start;
            int nextEnd = meeting.end;
            if(nextStart < previousEnd)
                ++count;
            if(end > nextStart) {
                ++count;
                max = Math.max(max, count);
            }
            previousEnd = end;
        }

        return max;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};
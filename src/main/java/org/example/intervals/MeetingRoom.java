package org.example.intervals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom {
    public static void main(String[] args) {
        Interval interval1 = new Interval(0,30);
        Interval interval2 = new Interval(5,10);
        Interval interval3 = new Interval(15,20);
        System.out.println(canAttendMeetings(Arrays.asList(interval1, interval2, interval3)));
    }

    //Time - o(nlogn)
    //Space -O(1)
    public static boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) return false;
        }

        return true;
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

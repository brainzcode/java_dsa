package arrays;

import java.util.ArrayList;

public class IntervalInsertion {
    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int i = 0;

        // Insert intervals that come before the new interval (no overlap)
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        // Handle Overlapping Intervals (merge if necessary)
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // Add the updated newInterval (after potential merge)
        result.add(newInterval);

        // Add the remaining intervals (no overlap)
        result.addAll(intervals.subList(i, intervals.size()));

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval newInterval = new Interval(2, 5);

        IntervalInsertion solution = new IntervalInsertion();
        ArrayList<Interval> result = solution.insert(intervals, newInterval);

        for (Interval interval : result) {
            System.out.println("(" + interval.start + ", " + interval.end + ")");
        }
    }
}

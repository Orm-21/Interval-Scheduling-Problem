import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InvtervalScheduling {

    private List<Interval> result;
    private Interval[] intervals;

    public InvtervalScheduling(Interval[] intervals) {
        result = new ArrayList<>();
        this.intervals = intervals;
    }

    public List<Interval> schedule() {
        // sort the intervals by end times
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.getEndTime()));

        if (intervals.length > 0) {
            // start by adding the first interval after sorting
            result.add(intervals[0]);
            int prevEndTime = intervals[0].getEndTime();

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].getStartTime() >= prevEndTime) {
                    result.add(intervals[i]);
                    prevEndTime = intervals[i].getEndTime();
                }
            }
        }

        return result;
    }


    public void printIntevals() {
        System.out.println("Sorted list of all intversals");
        System.out.println("–––––––––––––––––––––––––––––");
        int count = 1;
        for (Interval i: intervals) {
            System.out.print("Request " + count + ": ");
            System.out.println(i.toString());
            System.out.println();
            count++;
        }

    }

    public void printResults() {
        System.out.println("There are " + result.size() + " intervals that can be satistfied:");
        System.out.println("––––––––––––––––––––––––––––––––––––––––––––––");
        int count = 1;
        for (Interval i: result) {
            System.out.print("Request " + count + ": ");
            System.out.println(i.toString());
            System.out.println();
            count++;
        }
    }

    
}

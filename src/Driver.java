import java.util.Scanner;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of requests: ");
        int n = in.nextInt();
        System.out.println("Please the time frame for the requests: ");
        int time = in.nextInt();
        System.out.println();
        // our intervals will fall into the time frame [0, time]
        Random rand = new Random();

        // create out intervals
        Interval[] intervals = new Interval[n];
        // create 'n' amount of intervals
        for (int i = 0; i < n; i++) {
            // randomly generate a start and end time within the 'time' range
            int start = rand.nextInt(time);
            int end = rand.nextInt(time);
            while (start > end || (start == end)) {
                start = rand.nextInt(time);
                end = rand.nextInt(time);
            }
            intervals[i] = new Interval(start, end);
        }

        // run the greedy algorithm on the list of intervals
        InvtervalScheduling scheduling = new InvtervalScheduling(intervals);
        scheduling.schedule();

        // print all intevals (sorted)
        scheduling.printIntevals();
        // print the results
        scheduling.printResults();


        in.close();
    }
    
}

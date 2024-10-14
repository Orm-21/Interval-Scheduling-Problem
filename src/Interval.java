public class Interval {
    private int startTime;
    private int endTime;

    public Interval(int start, int end) {
        startTime = start;
        endTime = end;
    }

    @Override
    public String toString() {
        return "[" + startTime + ", " + endTime + "]";
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }
    
}

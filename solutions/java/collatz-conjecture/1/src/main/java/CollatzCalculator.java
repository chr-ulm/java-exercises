class CollatzCalculator {

    int computeStepCount(int start) {
        if(start<1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return step(start,0);
    }

    private int step(int count, int steps) {
        if (count == 1) {
            return steps;
        }
        if(count % 2 == 0) {
            return step(count/2,steps+1);
        }
        return step((count*3)+1,steps+1);
    }

}

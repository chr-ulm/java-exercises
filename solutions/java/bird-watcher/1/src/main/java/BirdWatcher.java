
class BirdWatcher {
    private final int[] birdsPerDay;
    private final int[] birdsLastWeek = {0,2,5,3,7,8,4}; // Realistically, we should havve a function to pull this from storage somewhere

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsLastWeek;
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : this.birdsPerDay){
            if(birds == 0){
                return true;
            }
        }
        return false;
    }
    

    public int getCountForFirstDays(int numberOfDays) {
        int birds = 0;

        // Sanity check on input
        if (numberOfDays > this.birdsPerDay.length){
            numberOfDays = this.birdsPerDay.length;
        }
        
            for(int i = 0; i < numberOfDays; i++) {
            birds += this.birdsPerDay[i];
        }
        return birds;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int birds : this.birdsPerDay){
            if(birds >= 5){
                busyDays++;
            }
        }
        return busyDays;
    }
}

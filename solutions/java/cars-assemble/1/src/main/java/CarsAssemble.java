public class CarsAssemble {
    
    private final int BASE_PRODUCTION = 221;
    
    public double productionRatePerHour(int speed) {
        if(speed < 5)
            return this.BASE_PRODUCTION * speed;
        if(speed < 9 )
            return this.BASE_PRODUCTION * speed * 0.9;
        if(speed < 10)
            return this.BASE_PRODUCTION * speed * 0.8;
        return this.BASE_PRODUCTION * speed * 0.77;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed)/60;
    }
}

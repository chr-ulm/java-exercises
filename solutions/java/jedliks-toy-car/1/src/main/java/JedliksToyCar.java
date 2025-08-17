public class JedliksToyCar {
    private int drivenMeters;
    private int batteryPercent = 100;
    
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %s meters",drivenMeters);
    }

    public String batteryDisplay() {
        if (batteryPercent == 0) {
            return "Battery empty";
        }
        return String.format("Battery at %s%%",batteryPercent);
    }

    public void drive() {
        if(batteryPercent > 0) {
            this.drivenMeters += 20;
            this.batteryPercent -= 1;
        }
    }
}

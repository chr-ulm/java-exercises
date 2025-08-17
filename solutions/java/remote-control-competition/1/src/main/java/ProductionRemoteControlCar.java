public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int speed = 10;
    private int batteryDrain = 1;
    private int batteryPercentage = 100;
    private int distanceDriven = 0;
    private int numberOfVictories = 0;

    /*ProductionRemoteControlCar(int speed, int batteryDrain){
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }*/
    
    public boolean batteryDrained() {
        return this.batteryPercentage < batteryDrain;
    }
    
    public int getDistanceTravelled() {
        return this.distanceDriven;
    }

    public void drive() {
            if(!this.batteryDrained()){
            this.distanceDriven += this.speed;
            this.batteryPercentage -= this.batteryDrain;
        }
    }
        public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(other.numberOfVictories, this.numberOfVictories);
    }
}

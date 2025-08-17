public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private int speed = 20;
    private int batteryDrain = 1;
    private int batteryPercentage = 100;
    private int distanceDriven = 0;

    /*ExperimentalRemoteControlCar(int speed, int batteryDrain){
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
}
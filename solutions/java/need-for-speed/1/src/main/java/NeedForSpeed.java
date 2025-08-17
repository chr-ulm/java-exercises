class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int batteryPercentage = 100;
    private int distanceDriven = 0;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.batteryPercentage < batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
            if(!this.batteryDrained()){
            this.distanceDriven += this.speed;
            this.batteryPercentage -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
}

class RaceTrack {
    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while(!car.batteryDrained()){
            car.drive();
        }
        return car.distanceDriven() >= this.distance;
    }
}

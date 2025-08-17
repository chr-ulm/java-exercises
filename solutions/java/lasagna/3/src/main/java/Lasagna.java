public class Lasagna {
    private static int MINUTES_IN_OVEN = 40;
    private static int MINUTES_PER_LAYER = 2;
    
    public int expectedMinutesInOven(){
        return MINUTES_IN_OVEN;
    }
    
    public int remainingMinutesInOven(int mins){
        return expectedMinutesInOven() - mins;
    }


    public int preparationTimeInMinutes(int layers){
        return layers*MINUTES_PER_LAYER;
    }


    public int totalTimeInMinutes(int layers,int time){
        return preparationTimeInMinutes(layers)+time;
    }
}

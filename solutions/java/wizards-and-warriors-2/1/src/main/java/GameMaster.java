public class GameMaster {

    public String describe(Character c) {
        return "You're a level " + c.getLevel() + " " + c.getCharacterClass() + " with " + c.getHitPoints() + " hit points.";
    }

    public String describe(Destination d) {
        return "You've arrived at " + d.getName() + ", which has " + d.getInhabitants() + " inhabitants.";
    }

    public String describe(TravelMethod t) {
        return "You're traveling to your destination " + (t == TravelMethod.WALKING ? "by walking" : "on horseback") + ".";
    }

    public String describe(Character c, Destination d, TravelMethod t) {
        return this.describe(c) + " " + this.describe(t) + " " + this.describe(d);
    }
    
    public String describe(Character c, Destination d) {
        return this.describe(c) + " " + this.describe(TravelMethod.WALKING) + " " + this.describe(d);
    }
}

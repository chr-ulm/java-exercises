public class Hamming {
    private final String leftStrand;
    private final String rightStrand;
    private int distance;
    
    public Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        int count = 0;
        for(int i=0;i<this.leftStrand.length();i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)){
                count++;
            }
        }
        this.distance = count;

    }

    public int getHammingDistance() {
        return this.distance;
    }
}

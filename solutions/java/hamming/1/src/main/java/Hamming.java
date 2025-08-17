public class Hamming {
    private char[] leftStrand;
    private char[] rightStrand;
    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
        if(this.leftStrand.length != this.rightStrand.length) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
    }

    public int getHammingDistance() {
        int count = 0;
        for(int i=0;i<this.leftStrand.length;i++) {
            if (this.leftStrand[i] != this.rightStrand[i]){
                count++;
            }
        }
        return count;
    }
}

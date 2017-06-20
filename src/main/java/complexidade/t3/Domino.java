package complexidade.t3;

public class Domino {
    private int left;
    private int right;
    private boolean flipped;
    private boolean used;

    public Domino(int left, int right) {
        this.left = left;
        this.right = right;
        this.flipped = false;
        this.used = false;
    }

    public boolean wasUsed() {
    	return this.used;
    }
    
    public void setUsed(boolean bool) {
    	this.used = bool;
    }
    
    /**
     * example:
     * [4,7] -> [7,4]
     */
    public void flip() {
        int aux = left;
        left = right;
        right = aux;
        flipped = !flipped;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
    
    @Override
    public String toString() {
    	return "[" + this.left + ", " + this.right + "]";
    }
}

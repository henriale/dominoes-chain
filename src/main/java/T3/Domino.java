package T3;

class Domino {
    private int left;
    private int right;
    private boolean flipped;

    Domino(int left, int right) {
        this.left = left;
        this.right = right;
        this.flipped = false;
    }

    /**
     * example:
     * [4,7] -> [7,4]
     */
    void flip() {
        int aux = left;
        left = right;
        right = aux;
        flipped = !flipped;
    }

    int getLeft() {
        return left;
    }

    int getRight() {
        return right;
    }
}

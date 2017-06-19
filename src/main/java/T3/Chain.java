package T3;

import java.util.LinkedList;

class Chain {
    private LinkedList<Domino> dominoes;

    Chain() {
        dominoes = new LinkedList<>();
    }

    public boolean dominoIsAttachable(Domino domino) {
        return dominoes.isEmpty() || dominoIsAttachableToTail(domino) || dominoIsAttachableToHead(domino);
    }

    private boolean dominoIsAttachableToHead(Domino domino) {
        return dominoes.isEmpty() || domino.getRight() == getTail() || domino.getLeft() == getTail();
    }

    private boolean dominoIsAttachableToTail(Domino domino) {
        return dominoes.isEmpty() || domino.getLeft() == getHead() || domino.getRight() == getHead();
    }

    public void attachDomino(Domino domino) throws Exception {
        if (dominoIsAttachableToHead(domino)) {
            attachDominoToHead(domino);
        } else if (dominoIsAttachableToTail(domino)) {
            attachDominoToTail(domino);
        }

        throw new Exception("Error");
    }

    public void attachDominoToTail(Domino domino) {
        if (domino.getRight() != getTail()) {
            domino.flip();
        }

        dominoes.addFirst(domino);
    }

    public void attachDominoToHead(Domino domino) {
        if (domino.getLeft() != getHead()) {
            domino.flip();
        }

        dominoes.addLast(domino);
    }

    public Domino detachDominoFromTail() {
        return dominoes.removeFirst();
    }

    public Domino detachDominoFromHead() {
        return dominoes.removeLast();
    }

    private int getTail() {
        return dominoes.getFirst().getLeft();
    }

    private int getHead() {
        return dominoes.getLast().getRight();
    }
}

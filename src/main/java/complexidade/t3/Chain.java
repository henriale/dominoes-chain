package complexidade.t3;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Chain {
    private LinkedList<Domino> dominoes;

    public Chain() {
        this.dominoes = new LinkedList<>();
    }

    public boolean dominoIsAttachable(Domino domino) {
        return dominoes.isEmpty() || dominoIsAttachableToTail(domino) || dominoIsAttachableToHead(domino);
    }

    public boolean dominoIsAttachableToHead(Domino domino) {
        return dominoes.isEmpty() || domino.getRight() == getHead() || domino.getLeft() == getHead();
    }

    public boolean dominoIsAttachableToTail(Domino domino) {
        return dominoes.isEmpty() || domino.getLeft() == getTail() || domino.getRight() == getTail();
    }

    public void attachDomino(Domino domino) throws InvalidParameterException {
        if(dominoIsAttachableToHead(domino)) {
            attachDominoToHead(domino);
        } else if (dominoIsAttachableToTail(domino)) {
            attachDominoToTail(domino);
        } else {
            throw new InvalidParameterException("Cagada.");
        }
    }

    public void attachDominoToTail(Domino domino) {
        if (domino.getLeft() != getTail()) {
            domino.flip();
        }

        dominoes.addLast(domino);
    }

    public void attachDominoToHead(Domino domino) {
        if (domino.getRight() != getHead()) {
            domino.flip();
        }

        dominoes.addFirst(domino);
    }

    public Domino detachDominoFromTail() {
        return dominoes.removeLast();
    }

    public Domino detachDominoFromHead() {
        return dominoes.removeFirst();
    }

    public int getTail() {
        if(!dominoes.isEmpty()) {
            return dominoes.getLast().getRight();
        }

        return -1;
    }

    public int getHead() {
        if(!dominoes.isEmpty()) {
            return dominoes.getFirst().getLeft();
        }

        return -1;
    }
    
    public List<Domino> get() {
    	return this.dominoes;
    }

	public void detachDomino(Domino domino) {
		if(domino.equals(dominoes.getFirst())) {
			this.detachDominoFromHead();
		} else if(domino.equals(dominoes.getLast())) {
			this.detachDominoFromTail();
		} else throw new InvalidParameterException("Falha ao remover " + domino + " da cadeia " + dominoes);
	}

    @Override
    public String toString() {
        String response = "";
        for (Domino domino: dominoes) {
            response += domino.toString() + " ";
        }

        return response.trim();
    }
}
